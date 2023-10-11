pipeline{
    agent any
        stages{
            stage("Build"){
                steps{
                    sh "mvn /webproject/POM.xml -DskipTests clean package" 
                }
            }
            stage("Test"){
                steps{
                    sh "mvn --projects webproject test"
                }
            }
               
    }
}
