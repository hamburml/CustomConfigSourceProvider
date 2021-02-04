1. mvn package
2. java -jar .\config-service-1.0-SNAPSHOT-runner.jar // this uses stage.properties
3. java -Dstage=uk_ -jar .\config-service-1.0-SNAPSHOT-runner.jar // this uses uk_stage.properties which does not have key "property". But this key is used in ConfigResult.java. Value of stage.properties is used