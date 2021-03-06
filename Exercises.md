
### Математика и Геометрия

- Задан треугольник со сторонами **_A = 4, B = 5 , C = 6_**. Найти площадь треугольника 
по формуле [Герона](https://ru.wikipedia.org/wiki/%D0%A4%D0%BE%D1%80%D0%BC%D1%83%D0%BB%D0%B0_%D0%93%D0%B5%D1%80%D0%BE%D0%BD%D0%B0).
- Вычислить площадь круга. Данные дожны вводиться из консоли, пользователю должно 
предлагаться два варианта на выбор. Либо ввод радиуса круга либо диаметра. Результат вывести
пользователю на консоль в округленном виде до 2-х знаков после запятой.
- Задан отрезок **_[a, b]_**. Определить что введенное из консоли значение находится на этом отрезке.
- В декартовой системе координат задан треугольник с координатами точек **_A(0,0) B (5, 6) C(0, 10)_**.
Вычислить периметр и площадь треугольника.
- В декартовой системе координат задан квадрат _**A(10, 10) B (-10 , 10) C(-10, -10) D (10, -10)**_.
Определить находится ли введенная с консоли точка внутри заданного квадрата.
- Задана функция **y = sin2x**. Построить таблицы значений **x,y** на промежутке **[0.2, 0.4]**
с шагом **0.01**. Результатом должно быть два массива, один который хранит **x** значения функции,
второй хранит **y**.
- Задана функция ![](src/main/resources/images/equation-001.jpg). Вывести на консоль значения
точек **(x,y)** на интервале **x [10, 100]** с шагом **1.5**
- Задано квадратное уравнение в виде строки
    ```
    String equation = "x2 - 3x +3 = 0"; // где x2 - это х в квадрате
    ```
    Найти решения [квадратного уравнения](https://ru.wikipedia.org/wiki/%D0%9A%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82%D0%BD%D0%BE%D0%B5_%D1%83%D1%80%D0%B0%D0%B2%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5)
- Пользователь вводит с консоли число в десятеричном формате. Подсчитать сколько единиц введенное
число содержит в двоичном формате

    _Например_

    ```
    Пользователь вводит число 5. В двоичном виде это 101 -> ответ 2 
    (Подсказка - нужно поисследовать методы например класса Integer)
- Задано число
    ```
    int a = 123456789;
    ```
    Инвертировать числа переменной **a**
    
    _Например_
    
    ```
    int b = 321 => результат должен быть 123
    ```

### Циклы
- Используя циклы  **for, for-each, while, do-while** вывести на консоль
    ```
    * * * * * * * * * * * * * * * (15 звездочек, между которыми есть пробелы) 
    ```
- Пользователь вводит из консоли значение размера стороны квадрата.
Нужно вывести на консоль в виде _*_

    _Например_
    
    Пользователь вводит с консоли 6 (размер стороны квадрата)
   ```
    ******
    *    *
    *    *
    *    *
    *    *
    ******
    ```
- Всеми известными циклами вывести на консоль фигуру
    ```
     *
     *
     *
     *
     *
     *
     *
     *
     ********************
    ```
- Построить пирамиду в консоли, в зависимости от того какое значение основания пирамиды
 вводит пользователь (значения должны быть нечетными и начинаться с числа **3**)

    _Например_
    
    Пользователь вводит значение 7, на консоли должен быть следующий вывод
    
    ```   
          *  
         ***
        *****
       *******
       
       А также вывести зеркальное отражение
       
       *******
        *****
         ***
          *
    ```
- Построить ромб в консоли в зависимости от введенного пользователя значения длинны
    горизонтальной диагонали (значения должны быть нечетными и начинаться с числа **3**)
    
    _Например_
    
    ```
    Пользователь ввел значение 5 для диагонали, но консоли должен быть следующий вывод
    
        *
       ***
      *****
       ***
        *
    ```
- Построить два треугольника в консоли, в зависимости от размера введенного
пользователем длинны катета (значения должны быть нечетными и начинаться с числа **3**)

    _Например_
    
    ```
    Пользователь ввел значение 5
    
    *                *
    **              **
    ***            ***
    ****          ****
    *****        *****
    ```
- Всеми известными циклами вывести на консоль фигуру
    ```
    ************
               *
    ************
    *
    ************
               *
    ************
    *
    ************
               *
    ************
    *
    ************
    ```
- Всеми известными циклами вывести на консоль фигуру
    ```
    *
      *
        *
          *
            *
              *
                *
                  *
                    *
                      *
                        *
                          *
    ```
- Всеми известными циклами вывести на консоль фигуру
        
        *                     * 
          *                   *
            *                 *
              *               * 
                *             *
                  *           *
                    *         *
                      *       *
                        *     * 
                          *   *
                            * *
                              *
        
- Всеми известными циклами вывести на консоль фигуру, в зависимости от введенного
пользователем значения диагонали

    _Например_
    
    ```
    Пользователь вводит значение 5, на консоли долно отобразиться
    
    *
    **
    ***
    ****
    ***** - диагональ со  значением 5
    ****
    ***
    **
    *
    
    И также вывести зеркальное отображение
    
            *
           **
          ***
         ****
        ***** - диагональ со  значением 5
         ****
          ***
           **
            *
    ```
- С помощью всех известных циклов вывести на консоль
    ```
            *        *
            *        *
            *        *
            **********
            *        *
            *        *
            *        *
    ```

- С помощью всех известных циклов вывести на консоль

    ```
        *                       *
        *                       *
        *                       *
        *                       *
        *                       *
        *                       *
        *************************
    ```

- С помощью всех известных циклов вывести на консоль
    ```
    ***************************
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *                          *
    *                          *
    ```
- C помощью всех известных циклов вывести на консоль
    ```
             *
             *
             *
             *
       *************
       *************
       *************
       *************
       *************
             *
             *
             *
             *
    ```
- С помощью всех известных циклов вывести на консоль
    ```
    *************           *
    *           *           *
    *           *           *
    *           *           *
    *           *           *
    *           *           *
    *           *           *
    *           *           *
    *           *************
    ```
- C помощью всех известных циклов вывести на консоль
    ```
            *
           * *
          *   *
         *     *
        *       *
       *         *
      *           *
     *             *
    *               *
    ```
- C помощью всех известных циклов вывести на консоль
    ```
    *-----------*
    0*---------*0
    00*-------*00 м 
    000*-----*000
    0000*---*0000
    00000*-*00000
    000000*000000
    ```
- Всеми известными циклами вывести на консоль фигуру
    ```
           
                  *           *           *
                 * *         * *         * *
                *   *       *   *       *   *
               *     *     *     *     *     *
  ***********       *****       *****       ***********
    ```
### Строки

- Ввести с консоли три строки. Нужно получить новую строку, которая будет содержать все предыдущие строки.
- Задана строка. Определить количество символов строки и вывести на консоль.
  Далее все символы строки преобразовать в верхний регистр.]
- Задана строка
    ```
    String str = "Hello Java"
    ```
    Преобразовать стоку в массив символом и вывести массив на консоль
- Задана строка, каждый символ в строке преобразовать в [ASCII](http://www.asciitable.com/) код (десятиричный), 
    и получить суму все этих кодов.
    
    _Например_
    
    ```
       String str = "ABc"
       
       десятиричный код 'A' - 65
       десятиричный код 'B' - 66
       десятиричный код 'c' - 99
       
       результат 65 + 66 + 99 = 230
       
       Проеобразование символа в ASCII код делается путем ясного приведения типа
    ```
- Задана строка
    ```
    String str = "I have always wished for my computer to be as easy to use as my telephone; my wish has come true because I can no longer figure out how to use my telephone."; // (Bjarne Stroustrup)
    ```
    Сконвертировать данную строку в массив **char[]** и вывести на консоль
- Сгенерировать миллион строк, каждая строка должна содержать от 10 до 1000 символов, 
    размер строки тоже должен быть случайный но в заданном выше диапазоне. Для хранения всех этих
    строик использовать массив. Далее подсчитать колличество символов во всех строках массива.
- Задана строка
    ```
    String str = "variable";
    ```
   Поменять местами группы символов по 2
   
   _Например_
   
   ```
   String example = "java"   => "ajav" 
   ```
- Задана строка
    ```
    String str = "performance"
    ```
    Используя метод из класса String найти с какого индекса заданной строки начинается подстрока "for"
    
    _Например_
    
    ```
    String example = "java" => подстрока 'va' начинается со 2 индекса
    ```
- Сделать реверс строки
    ```
    String str = "The Java Virtual Machine"
    ```
    
    _Например_
    
    ```
    String example = "java" => "avaj"
    ```
    
- Написать программу которая определяет является ли введенная строка палиндромом
    
    _Например_
    
    ```
    "Anna", "Civic", "Kayak", "Racecar" => палиндромы
    "java", "maven", "git", "programming" => не палиндромы
    ```
- Задана строка
    ```
    String str = "C is quirky, flawed, and an enormous success."; //  (Dennis M. Ritchie)
    ```
    Из данной строки нужно получить строку которая будет состоять из первых символов слов
     данной строки-предложения
     
     _Например_
    ```
        String example = "Hello, World!" => "HW"
    ```
- Задана строка
    ```
    String str = "People think that computer science is the art of geniuses but the actual reality is the opposite, just many people doing things that build on each other, like a wall of mini stones."; // (Donald Knuth)
    ```
    Найти сколько раз символ _**'a'**_ встречается в данной строке
- Задана строка
    ```
    String str = "Measuring programming progress by lines of code is like measuring aircraft building progress by weight."; // (Bill Gates)
    ```
    Определить колличество пробелов в строке.
- Заданы два алгебраических уравнения в виде строки
    ```
    String equation1 = "(a + b) * (b + c) = 0";
    String equation2 = "(a + b) * (b + c) - (а + 4 + r)) = 0";
    ``` 
    Проверить два уравнения на валидность (в данном случае валидность воспринимать как
    колличество открытых и закрытых скобок в уравнении).
- Задана строка
    ```
    String str = "Talk is cheap. Show me the code." // (Linus Torvalds)
    ```
    Найти слова с максимальным и минимальным колличеством символов.
- Задана строка
    ```
    String str = "The Java programming language is strongly and statically typed."
    ```
    Преобразовать строку таким образом, чтобы каждый парный символ входил в новую строку.
    
    _Например_ 
    
    ```
    String example = "test"
    
    Результат должен быть => "et"
    ```
- Задана строка
    ```
    String str = "sazxcdgberquikmn"
    ```
    Отсортировать символы в порядке возрастания кода ASCII
- Задана строка
    ```
    String str = "932759327459013874365"
    ```
    Отсортировать символы в строке в порядке возрастания и вывести получившеюся строку на консоль
- Используя метод **join** из класса **String** произвести объединение в строку элементов массива по разделителю **-**
    ```
    String[] words = {"java", "jvm", "programming", "jit"}
    ```
- Задана строка-предложение
    ```
    String str = "The Java programming language is a general-purpose, concurrent, class-based, object-oriented language."
    ```
    Разбить данную строку на слова-подстроки и записать все в массив и вывести на консоль.
    При этом все знаки препинания должны быть удалены
    
    _Например_ 
    
    ```
    String example = "Hello, world!";
    ```
    
    Результатом должен быть массив из дву строк: **_"Hello" and "world"_**.
- Задана строка
    ```
    String str = "213875618237648197651872349801273784612837658723657832018208230840213840128340218340964"
    ```
    В данной стро строке оставить только те символы чисел которые меньше 5 (не включая 5 и 
    включая 0)
- Задана строка
    ```
    String str = "2138787653719082374879123674980126358761239084718237974901823749812374"
    ```
    Определить сколько раз в данной строке встречается символы от 0 до 9 и вывести статистику в консоль
- Задана строка
    ```
    String str = "2347865238";
    ```
    Выполнить перемножение двухзначных чисел
    
    _Например_
    
    ```
    String example = "1134" => 11 * 34 = 374
    String example = "10112233" => 10 * 11 * 22 * 33
    ```
- Задана строка
    ```
    String str = "iuqheiuehrg7jh34hj234jh5y287b23jhbhj34thj2b34thj";
    ``` 
    Определить сколько строка имеет цифровых символов
    
    _Например_
    
    ```
    String example = "asdfj345jkjh2k2"; => 34522 => 5 символов
    ```
- Задана строка
    ```
    String str = ""Hello, Java!";
    ```
    Строка должна быть так преобразована чтобы каждый символ в ней был на еденицу меньше в
    десятичной системе ASCII.
    
    _Например_
    
    ```
    String example = "loL";
    
    l - ASCII code 108 => 108 - 1 = 107 is code k
    o - ASCII code 111 => 111 - 1 = 110 is code n
    L - ASCII code  76 => 76 - 1 = 75 is code K
    
    String out = "knK"; 
    ```
- Задана строка
    ```
    String str = "sdgHjhgJHGHJggSLsjLKSkjhkjhSjhkSkhsk:LkS"
    ```
    Определить колличество символов в верхнем регистре
    
    _Например_
    
    ```
    String example = "abcEljkR" => 2
    ```
- Задана строка
    ```
    String str = "JHGJHGhjgHGUYGUYSJJKhjhkjUIUIHJhjhKJHGK";
    ```
    Определить количество символов в нижнем регистре
    
    _Например_
    
    ```
    String example = "ABCdfKILFp" => 3 
    ```
- Задана строка
    ```
    String str = "asdjfhwuqyetrnzxbcvcpoxincumbniuoqwyenzxcbmzvnbcqtyrenbvzcpoiedsfmngb"
    ```
    Определить сколько согласных в данной строке (согласными в английском языке являются
    **6** букв - a, e, i, o, u, y)
- Задана строка
    ```
    String str = "sdkfjgskjdfnvjksdfngjkasdafkbvka,msndiugkhbahjdfdbncva"
    ```
    Определить колличество согласных букв
- Задана строка
    ```
    String str = "fdsgnsdfjfakjhakjhsajhgaisahagsfihakjshfakjshfkashfjkahsf";
    ```
    
    В строке заменить все символы **'a'** на пробелы.
- Задана строка
    ```
    String str = "I want to become a programmer"
    ```
    
    После каждого символа вставить символ **1** (пробелы должны игнорироваться)
- Заданы строки
    ```
    String calc1 = "10 + 6";
    String calc2 = "23 - 11";
    String calc3 = "25 / 5";
    String calc4 = "4 * 7";
    ```
    Произвести парсинг строк(синтаксический анализ) и выполнить действие,
    которое задано в строке(в нашем случае 4 возможных *,/,+,-)
- Задан массив строк
    ```
    String[] array = {
                        "java",
                        "maven",
                        "git",
                        "programming",
                        "svn"
                    }
    ```
    Результатом должна быть строка которая будет содержать в "склееном" виде строки из
    массива таким образом, что каждое "склеивание" должно происходить не вконец 
    предыдущей строки а на место предпоследнего символа
    
    _Например_
    
    ```
    String example = {
                        "scala",
                        "python",       
                        go
                    }
        first iteration     => "scala"
        second iteration    => "scalpythona"
        third iteration     => "scalpythogona"
        
    ```
- Задана строка
    ```
    String str = "wejhbnpolkdshjnjwe"
    ```
    Преобразовать строку в две строки таким образом, чтобы в первой строке были только нечетные символы
    а во второй были только четные.
    
    _Например_
    
    ```
    String example = "abcd";
            
    String out1 = "ac";
    String out2 = "bd";   
    ```
- Задана строка
    ```
    String str = "Specific type conversions in the Java programming language are divided into 13 categories"
    ```
    Разбить данное предложение на строки по пробелу, в получившемся массива строк у каждой строки удалить
    первый и последний символы, если строка состоит из 3 символом то данное преобразование не делать

- Задана строка и массив
    ```
    int[] array = {1, 2, 3};
    String str = "Array has %s elements, the first element is %s, the last is %s"
    ```
    Используя метод и класса String вставить в данной строке вместо **%s** значения
- Сгенерировать 100_000 строк, для хранения строк использовать массив. Размер строки не должен превышать 1000 символов.
    В данном получившемся массиве найти строку в которой встречается максимальное колличество символов **'a'**

### Mасcивы
- Задан массив
    ```
    short[] array = {5, 4, 6, 8, 3, 23, 5, 67, 45, 4, 24, 6, 34}
    ```
    Отсортировать массив в порядке возврастания используя метод и класса _**Arrays**_
- Создать и заполнить все элементы массива одинаковыми значениями (размер массива произвольный)
 используя методы из класса **Arrays**
- Задан массив
    ```
    int[] array = {3, 4, 5, 6, 8, 9, 0, 2, 3, 4, 6, 7, 8}
    ```
    Вывести сумму всех элементов массива
- Задан массив
   ```
   byte[] array = {3, 4, 5, 6, 3, 2, 5, 7, 8}
   ```
   Найти произведения всех элементов массива
- Задан массив
    ```
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
    ```
    Используя метод из класса **Arrays** скопируйте первую половину массива в новый массив
- Заданы три массива
    ```
    int[] array1 = {9, 8, 7, 6, 5}
    int[] array2 = {9, 8, 7, 6, 5, 4, 3, 2, 1}
    int[] array3 = {9, 8, 7, 6, 5}
    ```
     Используя метод из класса **Arrays** проверить массивы на идентичность элементов.
     (array1 и array2, array2 и array3, array1 и array3)
- Задан массив
     ```
     long[] array = {234, 3457, 657, 456, 89, 234, 2, 45243, 5, 423, 23, 5, 423, 52}
     ```
     Определить колличество четных и нечетных значений массива
- Задан массив
    ```
    int[] array = {1, 4, 6, 7, 34, 2, 12}
    ```
    Вывести в консоль все его элементы в обратном порядке
- Создать массив **int[]** размерностю (которая задается случайно), и заполнить массив
случайными элементами в пределах **[50, 1000]**. Вывести массив на консоль.
- Задан массив
    ```
    byte[] array = {3, 6, 5, 7, 34, 99, 6, 8, 32, -20, 45, -100}
    ```
    Найти наибольший и наименьший элементы массива
- Задан массив
    ```
    short[] array = {4, 5, -23, -1234, 456, 7, -44, -1, 45, 23, 23, 1, 2}
    ```
    Найти наименьшее по модулю значение 
- Задан массив
    ```
    long array = {5, 2, 1, 7, 9, 10, 1001, 44, 3445, 2222, 1234567, 0987, 3}
    ```
    Используя бинарный поиск найти в данном массиве элемент с значением 44
- Заданы два массива символов
    ```
    char[] array1 = {'a', 'v', 't', 'g', 'y', 'd'};
    char[] array2 = {'w', 'g', 'q', 'a', 'k', 'g', 'f', 'v'};
    ```
    Результатом должен быть массив который будет содержать все элементы приведенных
    выше двух массивов, фактически массивы нужно объеденить ("склеить")
- Задан массив
    ```
    int[] array = {4, 5, 456, 24, 23, 231, 231, 2314 ,123, 44, 21, 4}
    ```
    Получить массив double[] на основе входного к элементам которого будет 
    применена операция корня квадратного, результат каждого элемента округлить
    до 3-го знака после запятой
- Задан массив
    ```
    short[] array = {5, 7, 89, 0, 43, 34, 64, 23, 76}
    ```
    Найти [среднее арифметическое элементов](https://ru.wikipedia.org/wiki/%D0%A1%D1%80%D0%B5%D0%B4%D0%BD%D0%B5%D0%B5_%D0%B0%D1%80%D0%B8%D1%84%D0%BC%D0%B5%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5)
- Задан массив
    ```
    long[] array = {6, 4, 32, 432, 13, 54, 6, 56, 7, 6, 5}
    ```
    Найти [среднеквадратичное отклонение элементов](https://ru.wikipedia.org/wiki/%D0%A1%D1%80%D0%B5%D0%B4%D0%BD%D0%B5%D0%BA%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5_%D0%BE%D1%82%D0%BA%D0%BB%D0%BE%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5)
- Задан массив
    ```
    int[] array = {1, 4, 4, -356, 23, 324, 4, 4, -7, 8, 9, 0, -99999}
    ```
  Найдите сумму отрицательных элементов массива по модулю
- Найдите сумму **1 + 2 + 3 + … + n**, где число **n** вводится пользователем с клавиатуры.
- Задан массив строк
    ```
    String str = {"apple", "java", "git", "maven", "programming", "algorithm"}
    ```
    Результатом должен быть массив **int** элементы которого должны содержать количество
    символов соотвесттвующего элемента массива строк
    
    _Например_
    
    ```
    String example = {"python", "Go"} => int[] array = {6, 4}
    ```
- Задан массив
    ```
    int[] array = {2, 4, 15, 17, 45, 23, 5, 47 ,543, 234, 5 345, 23, 1}
    ```
    Вывести на консоль те элементы которые принаджежат интервалу [16, 300]
    
    _Например_
    
    ```
    int[] example = {5, 4, 6, 3, 7} интервал [6, 8] => 6, 7
    ```
- Задан массив
    ```
    int[] array = {4, 456, 35 , 43, 346, 234, 34, 74, 775, 234, 55, 45}
    ```
    Создать второй массив который будет хранить те элементы первого массива,
    которые меньше среднего арифметического всех элементов заданого массива
- Задан массив
    ``` 
    long[] array = {-4, 5, -22, -1, 45, -99, -98, -55, 5, 43, 7, 64, 77, 107}
    ```
    Найти сколько отрицательных чисел кратных 2
- Задан массив
    ```
    int[] array = {1232345234, 3455, 2324545, 12934554, 234, 6, 658, 78, 34634573457}
    ```
    Преобразовать данный массив в массив **long[]**
- Задан массив
    ```
    int[] array = { 1, 2, 4, 5, 3 , 1, 5, 10};
    ```
    Определить и найти если есть в данном массиве уникальный элемент (возможно несколько)
    
    _Например_
    ```
    int example = {1, 4, 6, 1, 4} => один уникальный элемент 6
    ```    
- Задан массив 
    ```
    int[] array = {4, 5, 6, 34, 435, 32, 4, 6}
    ```
    Получить вертикальное представление данного массива (Это будет двухмерный массив)
    
    _Например_
    
    ```
    int[] example = {1, 2, 3}
                
    
    int[][] example = {
        {1}, 
        {2},
        {3}
    }
    ```
- Задан массив
    ```
    int[] array = {2, 4, 5, 76, 3, 4, 6, 6, 3 4 2, 43, 234, 342, 2, 3 45, 23, 46};
    ```
    Вычислить сумму всех парных значений массива
    
    _Например_
    
    ```
    int[] example = {10, 2, 5, 8} => 10 + 2 + 8 = 20
    ```
- Задан массив
    ```
    byte[] array = {4, 5, 6, 4, 3, 12, 14, 16, 23, 24, 53 , 55, 45, 67, 33, 34, 44}
    ```
    Удалить из массива те элементы которые не входят в интервал **[15, 35]**
- Задан массив
    ```
    long[] array = {2345, 2346, 56, 7 ,45 , 32, 5, 234,5, 23, 45, 2543, 6, 3, 45 ,4568, 34, 56 , 34, 56}
    ```
    Преобразовать массив таким образом, что если элемент массива делится без остатка на 2 то записать 
    значение 1, если нет то 0
    
    _Например_
    
    ```
    int[] example = {4, 3} => {1, 0}
    ```
    
- Задан массив
    ```
    int[] array = {14, 63, 45, 75, 15, 4356 , 23, 12, 213, 1, 2341234, 23,  21, 77, 48}
    ```
    Создать массив который будет содержать элементы заданого массива, которые находятся в 
    диапазоне [15, 46] включительно.
    
    _Например_
    
    ```
    int[] example = {4, 6, 7, 9, 10} => диапазон [5, 9] => int[] out = {6, 7}
    ```
- Задан двухмерный массив чисел
    ```
        int[][] array = {
                        {1},
                      {4, 6},
                    {5, 4, 2},
                  {9, 5, 4, 7},
                {0, 4, 3, 4, 3},
              {4, 2, 1, 5, 6, 7},
            {5, 7, 8, 4, 2, 2, 3}
        }
    ``` 
    Нужно получить новый массив который будет зеркальным отражением относительно вертикали
    
    _Например_
    
    ```
        int[][] example = {                 int[][] example = {
                {1},                                {1},
              {5, 4},                 =>          {4, 5},
            {6, 7, 4}                           {4, 7, 6}    
        }                                   }
    ```
    Решить задачу общим случаем, т.е. для любого размера двухмерного массива
- Заданы массивы
    ```
    int[] array1 = {5, 4, 6, 8, 9, 3, 4};
    int[] array2 = {6, 7, 8, 9, 4, 5, 3}
    ```
    Нужно элементы массива поменять местами, по такому принципу что первый
    элемент первого массива менятюся местом с вторым элементов второго массива.
    И второй элемент первого массива меняется местом с первым элементом второго массива.
    И так далее по парно
    
    _Например_
    
    ```
    int[] example1 = {1, 2, 3, 4}   =>  {6, 5, 8, 7}
    int[] example2 = {5, 6, 7, 8}   =>  {2, 1, 4, 3} 
    
    ```
- Задан массив
    ```
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9}
    ```
    Преобразовать данный массив в двухмерный(матрицу), чтобы все элементы были
    элементами диагонали матрицы(у матрицы две диагонали потому нужно сделать две матрицы),
    остальные значения двухмерного массива заполнить нулями. Вывести два получившихся
    двухмерных массива на консоль.
    
    _Например_
    
    ```
    int[] example = {1, 2, 3}
    
    int[] out1 = {
                    {1, 0, 0},
                    {0, 2, 0},
                    {0, 0, 3}
                 }
                
    int[] out2 = {
                    {0, 0, 1},
                    {0, 2, 0},
                    {3, 0, 0}
                 }
    ``` 
- Заданы два массива
   ```
   long[] array1 = {345, 3, 45, 4, 5, 1, 55, 45, 54, 33, 34, 49}
   long[] array2 = {4100, 3, 6, 7, 54, 49, 1}
   ```
   Выполнить операцию пересечения множеств-массивов. Массив пересечения должен
   содержать только те элементы которые есть и в первом и во втором массивах.
   
   _Например_
   
   ```
   long[] example1 = {1, 2, 3, 4}
   long[] example1 = {3, 4, 5, 6}       
   
   long[] intersection = {3, 4}
   ```
- Задан массыв
    ```
    short[] array = {5, 4, 5, 7, 3, 8, 34, 234, 17, 19, 21, 44, 55, 67, 99, 100}
    ```
   Найти простые числа в заданном массиве
- Задан массив
    ```
    int[] array = {1, 22, 345, 234523456, 34532, 854, 456546, 77543, 2345234, 2345, 3245, 2, 47376, 345}
    ```
    Данный массив нужно преобразовать таким образом, чтобы каждое значение исходного массива было
    разделено на составные числа в новом массиве
    
    _Например_
    
    ```
    int[] example = {1, 234, 5678, 4, 33} => int[] example = {1, 2, 3, 4, 5, 6, 7, 4, 3, 3};
    ```
- Задан массив
    ```
    int[] array = {1, 1, 2, 3, 4, 4, 5, 5, 5, 5, 6, 7, 8, 9, 0, 0}
    ```
    Преобразовать массив таким образом чтобы в нем остались только те значения, которые
    не повторяются
- Задана матрица размера **_N x N_** (Двухмерный массив элементы которого **int**). 
    В данной матрице есть две диагонали. Нужно получить сумму всех элементов диагонали. 
    
    _Например_ 
    
    Расмотрим матрицу **_3x3_**
    ```
    | 4 | 2 | 3|
    | 3 | 8 | 4|   одна диагональ 4 + 8 + 6, вторая диагональ 3 + 8 + 5
    | 5 | 1 | 6| 
    ```
- Задан куб _**N x N x N**_. найти произведение элементов по всем 4-м диагоналям.

    _Например_ 
    
    Куб _**3 x 3**_
    ```
    int[][][] cub = {
            {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            },
            {
                    {10, 11, 12},
                    {13, 14, 15},
                    {16, 17, 18}
            },
            {
                    {19, 20, 21},
                    {22, 23, 24},
                    {25, 26, 27}
            }
    }
    
    первая диагональ    1 * 14 * 27 = 378
    вторая диагональ    3 * 14 * 25 = 1050
    третья диагональ    19 * 14 * 9 = 2394
    четвертая диагональ 21 * 14 * 7 = 2058
    ```
- Задан массив
    ```
    long[] array = {34, 54, 65, 234, 676, 86, 87, 3, 4, 5, 8, 456 ,456}
    ```
    Данный массив пребразовать в двухмерный таким образом чтобы заполнить одну 
    из диагоналей(треугольник) матрицы 4x4, остальные элементы матрицы заполнить нулями, 
    при этом если колличество элементов массива больше чем колличество элементов треугольника
    матрицы, то лишние элементы упускаем, если элементов наоборот мало то заполняем нулями.
    Заполнение треугольника в матрице их массива происходит последовательно.
    
    _Например_
    
    ```
    long[] example1 = {1, 2, 3, 4, 5, 6, 7, 8, 9}
    
    Матрица 3x3
    
   {
        {1, 2, 3},
        {0, 4, 5},
        {0, 0, 6}
   }
   элементы массива 7, 8, 9 упускаются
   
   Матрица 4x4
   
   {
        {1, 2, 3, 4},
        {0, 5, 6, 7},
        {0, 0, 8, 9},
        {0, 0, 0, _0_} недостающий элемент массива заполняем просто 0
   }
    ```