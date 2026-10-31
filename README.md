# lab3_sem3

Лабораторная работа № 4 
ФИО: Дудошников Илья Александрович 
Группа: КБ-251

Примеры входных файлов находятся в figures.txt

Задание 1:
В панели Maven в Execute Maven Goal ввел wrapper:wrapper
.\mvnw.cmd clean package в терминале
Далее java -jar target\java-labs-1.0.0.jar в терминале - запуск

Задание 2: 
.\mvnw.cmd test запуск тестов
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

Задание 3:
.\mvnw.cmd test запуск тестов
[INFO] Tests run: 37, Failures: 0, Errors: 0, Skipped: 0

Задание 4:
.\mvnw.cmd test запуск тестов
[INFO] Tests run: 48, Failures: 0, Errors: 0, Skipped: 0

Задание 5:
.\mvnw.cmd test
[INFO] Tests run: 48, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

.\mvnw.cmd clean package

[INFO] Results:
[INFO] 
[INFO] Tests run: 48, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.4.2:jar (default-jar) @ java-labs ---
[INFO] Building jar: C:\Users\sasad\OpenideProjects\lab3_sem3\target\java-labs-1.0.0.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

Изменил файл Circle

[ERROR] Failures: 
[ERROR]   CircleTest.areaOfRadiusHalfIsQuarterPi:33 expected: <0.7853981633974483> but was: <1.5707963267948966>                                                                                                        
[ERROR]   CircleTest.areaOfRadiusTwoIsFourPi:27 expected: <12.566370614359172> but was: <6.283185307179586>
[ERROR]   CylinderTest.volumeOfCylinderWithCircleRadiusHalfAndHeightFour:74 expected: <3.141592653589793> but was: <6.283185307179586>                                                                                  
[ERROR]   CylinderTest.volumeOfCylinderWithCircleRadiusTwoAndHeightThree:67 expected: <37.69911184307752> but was: <18.84955592153876>                                                                                  
[INFO] 
[ERROR] Tests run: 48, Failures: 4, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE

Изменил обратно файл

[INFO] Tests run: 48, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

