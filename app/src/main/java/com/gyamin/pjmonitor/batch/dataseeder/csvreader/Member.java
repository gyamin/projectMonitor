package com.gyamin.pjmonitor.batch.dataseeder.csvreader;

import com.gyamin.pjmonitor.entity.MstWorkers;
import com.gyamin.pjmonitor.entity.TrnWorked;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *  Member.csvを読み込み、作業者データをオブジェクト化しリターンする
 * @author gyamin
 */
public class Member {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Member.class.getName());

    // 取り込みCSVファイル
    private final String fileName = "Member.csv";

    /**
     *  Member.csvを読み込み、銘柄オブジェクト配列を作成し、リターンする
     */
    public ArrayList<MstWorkers> getImportBeansFromFile(boolean skipFirstLine) {
        FileReader file = null;
        try {
            file = new FileReader(System.getProperty("user.dir") + "/design/seeds/" + fileName);
            BufferedReader br = new BufferedReader(file);
            String line;
            ArrayList<MstWorkers> mstWorkersArrayList = new ArrayList<>();
            while((line = br.readLine()) != null) {
                if(skipFirstLine == true) {
                    skipFirstLine = false;
                    continue;
                }
                // ,区切りで文字列を配列に格納
                String[] cols = line.split(",");
                MstWorkers mstWorkers = new MstWorkers();
                // MstWorkersオブジェクトにCSV値を設定
                mstWorkers.setId(Integer.valueOf(cols[0]));
                mstWorkers.setFamilyName(cols[1]);
                mstWorkers.setFirstName(cols[2]);
                mstWorkers.setFamilyNameKana(cols[3]);
                mstWorkers.setFirstNameKana(cols[4]);
                mstWorkers.setDepartmentId(Integer.valueOf(cols[11]));

                LocalDateTime sysDate = LocalDateTime.now();
                mstWorkers.setCreatedAt(sysDate);

                mstWorkersArrayList.add(mstWorkers);
            }
            return mstWorkersArrayList;

        } catch (FileNotFoundException ex) {
            String msg = this.fileName + " が存在しません。";
            log.error(msg + ex.toString());

        } catch (IOException ex) {
            log.error(ex.toString());
        } catch (Exception ex) {
            log.error(ex.toString());
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                log.error(ex.toString());
            }
        }
        return null;
    }
}
