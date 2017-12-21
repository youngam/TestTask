Урок 0. Установка необходимого ПО, создание пустого проекта

Структура урока:

* Требования к курсу

* Соглашения по формату, стилю написанию кода

* Установка `Android Studio`

* Создание пустого проекта


# Требования к курсу

Желательными требованиями к прохождению этого курса являются:

* ознакомление с курсом [java SE](https://www.youtube.com/playlist?list=PLIU76b8Cjem48KXIy83YIm-QM6SwvzjQd)

* ознакомление с первыми 19 уроками [базового курса android](https://www.youtube.com/watch?v=mmUgcokRJ5k&list=PLIU76b8Cjem7oSU18zTKNfsyzrmf3Zubl)

Мнение одного из авторов курса:
«Исходя из своего опыта, лучшей практикой является изучение всех требований не перед курсами, а параллельно с прохождением. Я начинал изучать `Android`
с минимальными знаниями `Java`. Когда их откровенно не хватало, я просто откладывал `Android`, изучал соответсвующую тему по `Java`, а потом возвращался
к курсам по `Android`. Естественно, что это подойдёт не каждому, но вам важно знать, что необязательно изучать эти темы последовательно.»

Подчёркиваем, что требования являются желательными. Во всех уроках будут ссылки на необходимые ресурсы, если вы не понимаете каких-то вещей.
Так что можете смело приступать к обучению, но как только понимаете, что не хватает знаний из предыдущих курсов, то сразу переключайтесь на них.

Целью модуля является создание `Colibri Tweet` - клиентского приложения, которое общается с реальным сервером. Результат, который вы получите,
пройдя первый модуль данного курса, вы уже видели на промо видео.

# Соглашения по формату, стилю написанию кода

В данном модуле мы пишем `java` код согласно [последним рекомендациям от google](https://google.github.io/styleguide/javaguide.html).

Отличительные особенности от распространённого подхода: 

* имена полей класса не начинаются с префикса `m`.

* имена статических полей не начинаются с префикса `s`. 

Эти префиксы широко использовались долгое время, но в данный момент от них решили отказаться в связи с тем, что современные среды разработки (типа `AndroidStudio`) позволяют легко отличить разные виды переменных.

Т.к. для `xml` файлов нет каких-либо официальных соглашений, то мы будем стараться следовать [этому подходу](https://jeroenmols.com/blog/2016/03/07/resourcenaming/).

Также следуем отметить, что очень часто мы будем показывать только часть кода из `java`, `xml` файлов. В таких случаях будут оставляться соответствующие комментарии. Не добавляйте эти комментарии в свой код, т.к. они носят чисто информативый характер.

Пример `java` кода:

*UserInfoActivity.java*
```
#!java
public class UserInfoActivity extends AppCompatActivity {
	// Остальной код выше не изменился
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userImageView = findViewById(R.id.user_image_view);
    }
}
``` 

Т.е в данной ситуации вам необходимо изменить метод `onCreate`, при этом не меняя весь остальной код в файле `UserInfoActivity.java`.

Пример `xml` кода:

*activity_user_info.xml*
```
#!xml
<RelativeLayout>
    <!--Остальные элементы сверху не изменились -->
    <TextView
        android:id="@+id/followers_text_view"
        android:layout_below="@id/user_location_text_view"
        android:layout_toEndOf="@+id/following_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginTop="5dp"
        android:text="Читатели"
        android:textSize="16sp"/>
</RelativeLayout>
```

В этом случае вы изменяете элемент `followers_text_view`, не изменяя остальные аттрибуты.


# Установка *Android Studio*

Единственная программа, необходимая для разработки мобильного приложения - `Android studio`. Всё, что необходимо сделать для установки:

* Скачать установочник `AndroidStudio 3.0` с [официального сайта](https://developer.android.com/studio/index.html).

После того, как запустим установку программы и нажмём кнопку `Next`, увидим окно выбора компонентов. Выбираем все, т.к. мы будем запускать наше
приложение на эмуляторе. Выглядит это так:      
  
![AvdSetup.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/AvdSetup.png)

После этого надо выбрать пути приложения и его название. Эти данные оставляем неизменными:

![Path.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/Path.png)

![Name.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/Name.png)

Далее ждём конца установки программы. После установки у вас появится окно, сигнализирующее об окончании установки приложения.

![SetupFinished.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/SetupFinished.png)

Нажимаем кнопку `Finish` (чекбокс о запуске приложения после нажатия кнопки стоит автоматически).

После запуска программы видим окно, которое спрашивает, хотим ли мы импортировать настройки из предыдущей версии `Android Studio`. Если у вас до этого была установлена `Android Studio`, то нажимайте первый вариант, иначе - второй.

![ImportSettings.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/ImportSettings.png)

После этого появится экран с описанием, который сигнализирует о том, что у нас не установлено `SDK`. Просто нажимаем `Next`.

![SetupWizard.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/SetupWizard.png)

После этого появится окно, в котором необходимо выбрать тип установки. Выбираем `Standard`.

![InstallationType.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/InstallationType.png)

После этого появится окно выбора темы. В наших уроках мы будем использовать тёмную тему `Darcula`. Если вы хотите, то тоже можете выбрать эту тему на этом этапе или поменять её в любое другое время. Выбираем любую из двух тем и нажимаем `Next`.

После этого перед нами появляется окно, которое отображает части `SDK`. `SDK`(Software development kit). `SDK` - набор библиотек для разработки
приложений для операционной системы `Android`. Без установки `SDK` мы не сможем начать работу, т.к. не будем иметь доступ к базовым классам системы `Android`.
Также отображется путь, куда будет установлено `SDK`.

Ничего не меняем, нажимаем `Next`.
После этого появляется окно о подтверждении скачивания `SDK`. Нажимаем `Finish`.

![SdkConfirm.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/SdkConfirm.png)

Дожидаемся загрузки `SDK` и компонентов. После окончания загрузки нажимаем кнопку `Finish`. 
Перед нами появится стартовая панель приложения. 

## Изменение темы на тёмную

Отметим, что в наших курсах мы используем тёмную тему `Darcula`, поэтому скриншоты будут тёмного цвета. По умолчанию у вас будет стоять светлая тема,
но содержание будет таким же. Если вы также хотите использовать тёмную тему, то можете выполнить следующие действия:

* Нажать на кнопку `Configure`, которая находится в правом нижнем углу

* Нажать на элемент `Settings`, как отображено на рисунке.

![Settings.jpg](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/Settings.jpg)

* После этого в правой части экрана в элементе `Theme` выберем значение `Darcula`, как показано на рисунке.

![Darcula.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/Darcula.png)

После этого нажимаем кнопку `apply` и кнопку `ok`. Наша тема должна стать тёмной после этого.

# Создание пустого проекта

Для начала создадим новый проект. Для этого нажимаем на пункт `Start a new Android Studio project`. 

![NewProject.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/NewProject.png)

После этого у нас появилось с окно с информацией о приложении.

![AppInfo.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/AppInfo.png)

Нам надо заполнить 3 поля:

* `Application name` - имя приложения. Наше приложение называется `ColibriTweet`.

* `Company domain` - пакет приложения. Здесь тоже можете указать `com.dev.colibri`.
Пакет используется для идентификации приложения на устройстве, также при загрузке в `Play Market`. Т.е. двух приложений с одним и тем же пакетом на `Android` устройстве и в `Play Market` быть не может. 

* `Project location` - путь вашего проекта. Обычно создают отдельную папку для `Android` проектов, но вы можете сделать по-своему.

Отлично, нажимаем кнопку `Next`.
Видимо окно следующего вида:

![TargetDevices.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/TargetDevices.png)

Здесь нам надо выбрать, какие устройства(планшеты, телефоны, телевизоры и т.д.) наше приложение будет поддерживать. Идеальный вариант - поддержка 100%
всех устройств. Но это наклыдвает определённые ограничения на ваши действия и создаёт трудности при написании кода. Мы будем поддерживать только телефоны
и планшеты (`Phone and Tablet`), начиная с 17 версии. Для этого надо выбрать из выпадающего списка вариант `API 17: Android 4.2(Jelly Bean)`. Выглядит это так:

![TargetDevices17.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/TargetDevices17.png)

Отлично, нажимаем кнопку `Next`.
Видим форму, предлагающую выбрать шаблон экрана.

![AppTemplate.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/AppTemplate.png)

По умолчанию стоит вариант `EmptyActivity`. Нам он подходит, поэтому нажимаем кнопку `Next`.

Теперь нам осталось указать имя для нашей `Activity` и нашего `layout` файла. Первый экран, который мы будем делать называется `UserInfoActivity`,
а `layout` - `activity_user_info`. Давайте введём эти имена:

![UserInfoActivityName.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/UserInfoActivityName.png)

После этого нажимаем кнопку `Finish` и ждём, пока наш проект соберётся.

После того, как наш проект запустится у вас, возможно, появится ошибка, которая говорит о том, что у нас не хватает данных для запуска приложения.
Выглядит она так.

![InstallMissingPlatforms.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/InstallMissingPlatforms.png)

Для того, чтобы её исправить необходимо кликнуть по надписи в ошибке `Install missing platform and sync project` (она подсвечивается синим цветом).

После этого появится окно подтверждения, в котором необходимо нажать кнопку `accept`, после чего нажать кнопку `Next`.

![AcceptInstalling.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/AcceptInstalling.png)

После этого начнётся загрузка пакетов `SDK`, которые необходимы для создания проекта.

После того, как мы загрузили часть компонентов. Приложение попытается пересобраться и вы увидите ещё одну похожую ошибку.

![BuildToolsError.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/BuildToolsError.png)

Опять нам необходимо кликнуть по надписи в ошибке `Install missing platform and sync project` (она подсвечивается синим цветом). После нажатия у нас опять
загрузятся необходимые компоненты. После загрузки наш проект наконец-то собрался. Давайте запустим его. Для этого нажмём сочетание клавиш
`shift + F10`, или на иконку запуска:

![BuildIcon.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/BuildIcon.png)

Увидим окно выбора устройств. Видим, что нет доступных устройств. Давайте нажмём кнопку `Create New Virtual Device`:

![ChooseDevice.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/ChooseDevice.png)

После этого появится окно выбора нашего устройства. По умолчанию выбран `Nexus 5X`. Он нам подойдёт, поэтому его и скачиваем:

![DeviceNexus5x.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/DeviceNexus5x.png)

После этого появится окно скачивания устройства. Для начала нам необходимо в правом нижнем углу нажать на кнопку `Install Haxm`:

![InstallHaxm.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/InstallHaxm.png)

После появится экран с рекомендуемым объёмом памяти для нашего виртуального устройства. Оставляем рекомендуемый объём:

![RecommendedSize.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/RecommendedSize.png)

Также нам необходимо нажать на `Download` в строке `API 27`:

![ApiLevelDownload.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/ApiLevelDownload.png)

Опять появится форма подтверждения, нажимаем `Next`:

![AcceptAvd.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/AcceptAvd.png)

После того, как мы скачали нужный нам `API 27`, нам необходимо выбрать его и нажать кнопку `Next`:

![Api27Downloaded.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/Api27Downloaded.png)

Дальше появится окно детальной информации. В нём ничего не меняем:

![AvdDetails.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/AvdDetails.png)

Нажимаем кнопку `Finish`.
И наконец-то перед нами появилось готовое устройство:

![Nexus5XCompleted.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/Nexus5XCompleted.png)

Давайте запустим приложение, выбрав только что добавленный нами эмулятор. Первая загрузка может длиться достаточно долго. Это зависит от мощности компьютера.
У нас она длилась `4 минуты 10 секунд`. Но это только первая загрузка. Остальные будут гораздо быстрее.

После запуска видим результат на нашем эмуляторе.

![ColibriTweet.png](http://android-learning.com/cp/wp-content/uploads/courses/colibri-tweet/lesson0/ColibriTweet.png)

Поздравляем! Вы только что прошли самую сложную часть: установили и подготовили всё необходимое для работы.

Полезные ссылки:

* [Ссылка для скачивания Android Studio](https://developer.android.com/studio/index.html)
* Русскоязычные:
    * [Java SE курс](https://www.youtube.com/playlist?list=PLIU76b8Cjem48KXIy83YIm-QM6SwvzjQd);
    * [Базовый курс Android](https://www.youtube.com/watch?v=mmUgcokRJ5k&list=PLIU76b8Cjem7oSU18zTKNfsyzrmf3Zubl);
