package com.example.java.gettingstarted.util;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by chunchun.xu on 2017/12/2.
 */

public class HttpUtils {
	private static final OkHttpClient mOkHttpClient = new OkHttpClient();
	/**
	 * 该不会开启异步线程。
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Response execute(Request request) throws IOException {
		return mOkHttpClient.newCall(request).execute();
	}
	/**
	 * 开启异步线程访问网络
	 * @param request
	 * @param responseCallback
	 */
	public static void enqueue(Request request, Callback responseCallback){
		mOkHttpClient.newCall(request).enqueue(responseCallback);
	}
	/**
	 * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
	 * @param request
	 */
	public static void enqueue(Request request){
		mOkHttpClient.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {

			}
		});
	}

}
