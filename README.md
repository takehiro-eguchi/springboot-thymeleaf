# springboot-thymeleaf
SpringBootとThymeleafを用いたサンプルプロジェクトです。

## プロジェクト構成

* Maven
    * ビルド、テスト、デプロイ等のライフサイクルを管理する
* spring-boot
    * spring-boot-starter-web
        * Webコンテナ(Tomcat等)を内包したWebアプリケーションフレームワーク
    * spring-boot-starter-thymeleaf
        * HTMLテンプレートエンジン(jspのようなもの)
    * spring-boot-starter-security
        * Webアプリケーションにおける認証認可フレームワーク
    * spring-boot-starter-data-jpa
        * データベース利用を行うフレームワーク
* h2
    * 開発用データベース、テーブルの自動作成などに対応しているため、サーバを立てる必要がない

## Maven設定
以下のファイルを **C:\Users\${ユーザ名}\.m2\settings.xml** として作成してください。

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <localRepository>${user.home}/.m2/repository</localRepository>
  <interactiveMode>true</interactiveMode>
  <usePluginRegistry>false</usePluginRegistry>
  <offline>false</offline>
  <proxies>
    <proxy>
      <id>http</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.nssys.co.jp</host>
      <port>8080</port>
      <nonProxyHosts>localhost</nonProxyHosts>
    </proxy>
    <proxy>
      <id>https</id>
      <active>true</active>
      <protocol>https</protocol>
      <host>proxy.nssys.co.jp</host>
      <port>8080</port>
      <nonProxyHosts>localhost</nonProxyHosts>
    </proxy>
  </proxies>
</settings>
~~~

