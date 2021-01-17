# Swipeable interface in android studio
-------------------------------------------
This demo was created to help everyone learn how to make swipeable interface in android studio. The code is commented and explained.

### How to download and run:
1. download the source code
2. unzip it in any folder you want
3. open Android Studio
4. navigate to File > Open > Your folder
5. run on your device

### How to implement into your project
When going by this tutorial please refer to source code in this repository.
1. Create your main class ([`MainActivity.java`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/java/hrubos/local/testapp/MainActivity.java))
2. Create main layout which will include tab menu and ViewPager2 ([`activity_main.xml`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/res/layout/activity_main.xml))
3. Create class which extends FragmentStateAdapter for managing fragments ([`ViewPagerAdapter.java`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/java/hrubos/local/testapp/ViewPagerAdapter.java))
    - This class will extend `FragmentStateAdapter`
    - We will overwrite methods `createFragment` and `getItemCount`
        - Those methods need to be overwritten so the `ViewPager2` gets fragments from our `List`
4. Create layouts for fragments ([`first_fragment.xml`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/res/layout/first_fragment.xml), [`second_fragment.xml`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/res/layout/first_fragment.xml), [`third_fragment.xml`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/res/layout/first_fragment.xml))
5. Create classes for our fragments ([`FirstFragment.java`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/java/hrubos/local/testapp/FirstFragment.java), [`SecondFragment.java`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/java/hrubos/local/testapp/SecondFragment.java), [`ThirdFragment.java`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/java/hrubos/local/testapp/ThirdFragment.java), ...)
    - Each `Fragment` will be our view and item in tab menu
    - **How to handle buttons is described in [`SecondFragment.java`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/java/hrubos/local/testapp/SecondFragment.java)**
6. Now we'll make some changes in our main class in order to make this app work (refer to [`MainActivity.java`](https://github.com/hruboson/swipeable-interface-android-studio-demo/blob/main/app/src/main/java/hrubos/local/testapp/MainActivity.java))
    1. Set `activity_main.xml` as its layout
    2. Initiate `ViewPager` - add element which will be displaying our fragments (in our case it will be element with id `viewPager`)
    3. Create `List` of `Maps` where we will store our fragments
        - Maps will help us get to the correct fragment by using its name
    4. Create `Maps` of `Fragments` (we will create method `setTablTitleAndFragment` to help us do that) and add them to the `List`
    5. Create `ViewPagerAdapter` instance and pass him our main class (`activity`) and `List` with our `Fragments`
    6. We also added `TabLayout` in our `activity_main.xml` so we will tell our main class to use it
        - this will populate the menu
    7. Finally create mediator which will link TabLayout with ViewPager
        -  The mediator will synchronize the ViewPager2's position with the selected tab when a tab is selected, and the TabLayout's scroll position when the user drags the ViewPager
 
