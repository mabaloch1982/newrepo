pipeline{
    agent any
        stages{
            stage("Build"){
                steps{
                    sh "mvn -f webproject/POM.xml  -DskipTests clean package" 
                }
            }
            stage("Test"){
                steps{
                    sh "mvn -f webproject/POM.xml test"
                }
            }
               
    }
}
