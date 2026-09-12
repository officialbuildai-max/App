package com.transsion.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public class ToastUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f44125a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private static Toast f44126b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Field f44127c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f44128d;

    /* renamed from: com.transsion.core.utils.ToastUtil$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$resid;

        AnonymousClass3(int i11, Context context) {
            this.val$resid = i11;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtil.f44126b != null) {
                ToastUtil.f44126b.setText(this.val$resid);
                ToastUtil.f44126b.setDuration(1);
                ToastUtil.d(ToastUtil.f44126b);
            } else {
                Toast unused = ToastUtil.f44126b = Toast.makeText(this.val$context.getApplicationContext(), this.val$resid, 1);
            }
            ToastUtil.f44126b.show();
        }
    }

    /* renamed from: com.transsion.core.utils.ToastUtil$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$msg;

        AnonymousClass4(String str, Context context) {
            this.val$msg = str;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtil.f44126b != null) {
                ToastUtil.f44126b.setText(this.val$msg);
                ToastUtil.f44126b.setDuration(1);
                ToastUtil.d(ToastUtil.f44126b);
            } else {
                Toast unused = ToastUtil.f44126b = Toast.makeText(this.val$context.getApplicationContext(), this.val$msg, 1);
            }
            ToastUtil.f44126b.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private Handler f44129a;

        a(Handler handler) {
            this.f44129a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f44129a.handleMessage(message);
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f44127c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f44127c.getType().getDeclaredField("mHandler");
            f44128d = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Toast toast) {
        try {
            Object obj = f44127c.get(toast);
            Handler handler = (Handler) f44128d.get(obj);
            if (handler == null || (handler instanceof a)) {
                return;
            }
            f44128d.set(obj, new a(handler));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void e(final int i11) {
        final Context a11 = qk.a.a();
        if (i11 <= 0) {
            return;
        }
        f44125a.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.f44126b != null) {
                    ToastUtil.f44126b.setText(i11);
                    ToastUtil.f44126b.setDuration(0);
                    ToastUtil.d(ToastUtil.f44126b);
                } else {
                    Toast unused = ToastUtil.f44126b = Toast.makeText(a11.getApplicationContext(), i11, 0);
                }
                ToastUtil.f44126b.show();
            }
        });
    }

    public static void f(final String str) {
        final Context a11 = qk.a.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f44125a.post(new Runnable() { // from class: com.transsion.core.utils.ToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtil.f44126b != null) {
                    ToastUtil.f44126b.setText(str);
                    ToastUtil.f44126b.setDuration(0);
                    ToastUtil.d(ToastUtil.f44126b);
                } else {
                    Toast unused = ToastUtil.f44126b = Toast.makeText(a11.getApplicationContext(), str, 0);
                }
                ToastUtil.f44126b.show();
            }
        });
    }
}
