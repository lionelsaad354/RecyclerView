package net.lionelsaad.recyclerviewwithswipe;

/**
 * Created by saadfauzi on 10/8/2017.
 */

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyAplication extends Application {
    public static final String TAG = MyAplication.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private static MyAplication myInstance;

    @Override
    public void onCreate(){
        super.onCreate();
        myInstance = this;
    }
    public static synchronized MyAplication getMyInstance(){
        return myInstance;
    }
    public RequestQueue getmRequestQueue(){
        if (mRequestQueue ==  null){
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue (Request<T> req, String tag){
        //membuat nilai default tag jika tag bernilai kosong
        req.setTag(TextUtils.isEmpty(tag)?TAG : tag);
        getmRequestQueue().add(req);
    }
    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getmRequestQueue().add(req);
    }
    public void cancelPendingRequests(Object tag){
        if (mRequestQueue !=null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
