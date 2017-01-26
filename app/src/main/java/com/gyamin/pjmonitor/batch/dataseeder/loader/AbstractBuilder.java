package com.gyamin.pjmonitor.batch.dataseeder.loader;


/**
 * データベーステーブルへのデータセットアップ抽象クラス
 * @author Yasumasa
 */
abstract class AbstractBuilder {
  /**
   * ファイルなどからデータを読み込みImportBeansデータを作成する
  */
  abstract void prepareImportBeansFromFile();
  
  /**
   * データセットアップ関数
   */
  abstract void buildUpData();
  
}
