package com.androidexample.restfulwebservice;

import android.content.Context;

public final class App {
 private static Context localContext;
 public static Context getLocalContext() {
  return localContext;
 }
 public static void setLocalContext(Context localContext) {
  App.localContext = localContext;
 }
}