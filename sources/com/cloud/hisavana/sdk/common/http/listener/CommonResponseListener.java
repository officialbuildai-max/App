package com.cloud.hisavana.sdk.common.http.listener;

import android.os.Handler;
import android.util.Log;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.c;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public abstract class CommonResponseListener<E> extends ResponseBaseListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public CommonResponseListener() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CommonResponseListener(boolean z10) {
        super(z10);
    }

    private void j(final int i11, final String str) {
        final Object obj;
        try {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                throw new RuntimeException("Missing type parameter.");
            }
            try {
                obj = GsonUtil.b(str, ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            } catch (Exception e11) {
                e4.b().e("ssp", "GsonUtil parseResponse " + Log.getStackTraceString(e11));
                obj = null;
            }
            Handler handler = this.f22170a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CommonResponseListener.this.h(i11, obj, str);
                    }
                });
            } else {
                h(i11, obj, str);
            }
        } catch (Throwable th2) {
            e4.b().e("ssp", "parseResponse " + Log.getStackTraceString(th2));
            c.netLog("CommonResponseListener --> 解析网络请求数据异常 --> parseResponse --> catch " + Log.getStackTraceString(th2));
            a(TaErrorCode.ERROR_RESPONSE_PARSING_FAILED);
        }
    }

    protected abstract void g(int i11, Object obj);

    public void h(int i11, Object obj, String str) {
        g(i11, obj);
    }

    public void i(int i11, String str) {
        j(i11, str);
    }
}
