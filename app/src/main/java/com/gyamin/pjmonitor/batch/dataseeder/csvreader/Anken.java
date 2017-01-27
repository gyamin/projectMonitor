package com.gyamin.pjmonitor.batch.dataseeder.csvreader;

import com.gyamin.pjmonitor.entity.TrnProjectOrders;
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
 *  Anken.csvを読み込み、受注データをオブジェクト化しリターンする
 * @author gyamin
 */
public class Anken {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Anken.class.getName());

    // 取り込みCSVファイル
    private final String fileName = "Anken.csv";


    public ArrayList<TrnProjectOrders> getImportBeansFromFile(boolean skipFirstLine) {
        FileReader file = null;
        try {
            file = new FileReader(System.getProperty("user.dir") + "/design/seeds/" + fileName);
            BufferedReader br = new BufferedReader(file);
            String line;
            ArrayList<TrnProjectOrders> trnProjectOrdersList = new ArrayList<>();
            while((line = br.readLine()) != null) {
                if(skipFirstLine == true) {
                    skipFirstLine = false;
                    continue;
                }
                // ,区切りで文字列を配列に格納
                String[] cols = line.split(",");

                TrnProjectOrders trnProjectOrders = new TrnProjectOrders();
                // TrnWorkedオブジェクトにCSV値を設定
                trnProjectOrders.setJobNo(cols[0]);
                trnProjectOrders.setDepartmentId(Long.valueOf(cols[9]));
                trnProjectOrders.setOrderName(cols[2]);
                trnProjectOrders.setSalesWorkersId(Long.valueOf(cols[5]));

                if(! cols[24].equals("")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
                    trnProjectOrders.setOrderedDate(LocalDate.parse(cols[24], formatter));
                }

                trnProjectOrders.setOrderedVolume(Long.valueOf(cols[34]));

                LocalDateTime sysDate = LocalDateTime.now();
                trnProjectOrders.setCreatedAt(sysDate);

                trnProjectOrdersList.add(trnProjectOrders);
            }
            return trnProjectOrdersList;

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
