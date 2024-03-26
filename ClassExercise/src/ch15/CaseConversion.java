package ch15;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaseConversion {
    public static void main(String[] args) {
        int transform = 0;
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase(("-U"))) {
                transform = 1;
            } else if (args[0].equalsIgnoreCase(("-L"))) {
                transform = -1;
            } else {
                System.err.println("輸入參數只可為空或[-U/-L]");
                System.exit(0);
            }
        }
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("source.txt");
            fileWriter = new FileWriter("result.txt");
            char[] buf = new char[1024];
            int readLen;
            while ((readLen = fileReader.read(buf)) != -1) {
                String s = new String(buf, 0, readLen);
                if (transform == 1) {
                    s = s.toUpperCase();
                } else if (transform == -1) {
                    s = s.toLowerCase();
                }
                fileWriter.write(s);
            }
            fileWriter.flush();
            System.out.println("資料讀取/寫入完畢");
        } catch (IOException e) {
            System.out.println("找不到檔案！");
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                System.out.println("關閉失敗");
            }
        }
    }
}
