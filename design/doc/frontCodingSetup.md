# フロント開発環境の構築

## 方針
+ SPA的に画面を構築する。(全てを1htmlで作成はせず、別の画面は別のhtmlを使う。)     
  Tomcatでは静的ファイルの配信を行い、サーバサイドでhtmlを生成しない。(jspを使わない。) 
+ cssはscss, JavaScriptはtypescriptを利用する。
+ JavaScriptライブラリとしてはvue.jsを利用する。
+ Tomcatでは動的なソース反映に難があるので、開発時はnpm http-serverを利用する。

## node.jsの準備
node.jsはnodebrewを利用し管理する。
```bash
$ nodebrew install-binary v6.9.4 
$ nodebrew use v6.9.4
use v6.9.4
```

## 開発に依存するnpmパッケージのインストール
```bash
$ npm install -g typescript
$ npm install -g http-server --save
$ npm install @types/jquery --save
$ npm install @types/vue --save
$ npm install watch --save
$ npm install node-sass --save
```

## 開発 

### http-serverによるコンテンツ配信
http-serverで静的コンテンツを配信する。
```bash
$ http-server ./dist/
Starting up http-server, serving ./dist/
Available on:
  http://127.0.0.1:8081
  http://192.168.10.103:8081
Hit CTRL-C to stop the server

```
※ Tomcatにデプロイした場合と同等のURLパスとなるように注意。

### http-server経由でTomcatへアクセスする
http-serverから配信されるwebソースを利用する場合、そのままではtomcatのAPIにアクセスできない。（クロスドメイン制約）   
回避するために、http-proxyを利用し以下のように接続設定を行う。

[ client ] --- 8100     :[ http-proxy ] --- 8101:[ http-server ] 静的webコンテンツ配信
[ client ] --- 8100/api*:[ http-proxy ] --- 8102:[ tomcat ] WebApi

上記を実現するため、npmパッケージのhttp-proxy, http-proxy-ruleを利用し、app/bin/proxyServer.jsにプロキシサーバを設定。       

