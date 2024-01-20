# Shopping App
It is a shopping Android application.

**API Used- https://fakestoreapi.com/

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


https://github.com/itscodezada17/ShoppingApp/assets/63585669/6013b15e-9b04-4dee-9312-67033882e974


<code><img height=400  src="https://github.com/itscodezada17/ShoppingApp/blob/e45ebb8feff0ab2a6606cb7e32ff7c3472ae7b9a/productList.png" alt="ss2"></code>
<img height=400  src="https://github.com/itscodezada17/ShoppingApp/blob/e45ebb8feff0ab2a6606cb7e32ff7c3472ae7b9a/productDetail.png" alt="ss2">
<img height=400  src="https://github.com/itscodezada17/ShoppingApp/blob/e45ebb8feff0ab2a6606cb7e32ff7c3472ae7b9a/cart.png" alt="ss2">
<img height=400  src="https://github.com/itscodezada17/ShoppingApp/blob/e45ebb8feff0ab2a6606cb7e32ff7c3472ae7b9a/checkout.png" alt="ss2">

  
# APK 
  APK - <a href="https://github.com/itscodezada17/ShoppingApp/blob/e45ebb8feff0ab2a6606cb7e32ff7c3472ae7b9a/ShoppingApp.apk" alt="APK Link"><img src="https://img.shields.io/badge/APK-DownLoadApk-yellowgreen"></a>
  
  Click on the button above and download from there.
