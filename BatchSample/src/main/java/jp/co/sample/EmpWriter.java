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
				// 出力先を作成する
				FileWriter fw = new FileWriter("C:\\Temp\\test.csv", true);
				PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

				// 内容を指定する
				pw.print(entity.getId());
				pw.print(",");
				pw.print(entity.getName());
				pw.println();

				// ファイルに書き出す
				pw.close();

				// 終了メッセージを画面に出力する
				System.out.println("出力が完了しました。");

			} catch (IOException ex) {
				// 例外時処理
				ex.printStackTrace();
			}
		}

	}

}
