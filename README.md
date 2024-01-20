# Shopping App
It is a shopping Android application.

#API Used- https://fakestoreapi.com/

# Features
1. Products List Page (List Of Products(having an Image, name and price and add to cart button))
2. Cart Page (List of products in cart with total price , remove from cart implemented locally)
3. Item Detail Page ((having an Image, name, Description, price and add to cart button))
4. CheckOut Page (Just a Simple Ui showing a text)

# Technologies Used
1. LANGUAGE : Kotlin , XML
2. Architechture : MVVM , Single Activity using Navigation
3. Dipendency Injection : Hilt
4. Network Call : Retrofit
5. Image Loading : Glide
6. List items : RecyclerView
7. used Coroutines(for network calls)

# Decisions 
1. Made all the features via Fake Store API.
2. API post call was mandatory for some features so implemented it locally with livedata(in viewModel) only.
3. Followed Proper Single Activity Architecture pattern using navigation component

# Assumptions 
1. Assumed that SneakerItem and SneakerDetail both have same models, I mean both api's will give same JSON response
2. Focused on Code Quality and Architecture , Readability following best practices and design patterns

# ScreenShots



<code><img height=400  src="" alt="ss2"></code>
<img height=400  src="" alt="ss2">
<img height=400  src="" alt="ss2">

  
# APK 
  APK - <a href="" alt="APK Link"><img src="https://img.shields.io/badge/APK-DownLoadApk-yellowgreen"></a>
  
  Click on the button above and download from there.
