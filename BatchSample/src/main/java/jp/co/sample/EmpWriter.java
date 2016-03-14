package jp.co.sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import jp.co.sample.entity.EmpEntity;

@Component("empWriter")
public class EmpWriter implements ItemWriter<EmpEntity> {

	@Override
	public void write(List<? extends EmpEntity> arg0) throws Exception {

		for (EmpEntity entity : arg0) {
			try {
				// �o�͐���쐬����
				FileWriter fw = new FileWriter("C:\\Temp\\test.csv", true);
				PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

				// ���e���w�肷��
				pw.print(entity.getId());
				pw.print(",");
				pw.print(entity.getName());
				pw.println();

				// �t�@�C���ɏ����o��
				pw.close();

				// �I�����b�Z�[�W����ʂɏo�͂���
				System.out.println("�o�͂��������܂����B");

			} catch (IOException ex) {
				// ��O������
				ex.printStackTrace();
			}
		}

	}

}
