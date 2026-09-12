package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import java.util.concurrent.ExecutorService;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public class sP {
    private static Sj Sj;

    /* loaded from: classes2.dex */
    public interface Sj {
        ExecutorService getAsyncStartActivityThreadPool();

        boolean isEnableAsyncStartActivity();
    }

    /* renamed from: com.bytedance.sdk.component.utils.sP$sP, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0237sP {
        void Sj();

        void Sj(Throwable th2);
    }

    public static Activity Sj(View view) {
        View findViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (findViewById = rootView.findViewById(R.id.content)) == null || (context = findViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    public static void Sj(Sj sj2) {
        Sj = sj2;
    }

    public static boolean Sj(Context context, Intent intent, InterfaceC0237sP interfaceC0237sP) {
        return Sj(context, intent, interfaceC0237sP, false);
    }

    public static boolean Sj(final Context context, final Intent intent, final InterfaceC0237sP interfaceC0237sP, boolean z10) {
        Sj sj2;
        ExecutorService asyncStartActivityThreadPool;
        if (!z10 || (sj2 = Sj) == null || !sj2.isEnableAsyncStartActivity() || (asyncStartActivityThreadPool = Sj.getAsyncStartActivityThreadPool()) == null) {
            return TKC(context, intent, interfaceC0237sP);
        }
        asyncStartActivityThreadPool.execute(new com.bytedance.sdk.component.Dq.Dq("startAct") { // from class: com.bytedance.sdk.component.utils.sP.1
            @Override // java.lang.Runnable
            public void run() {
                sP.TKC(context, intent, interfaceC0237sP);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean TKC(Context context, Intent intent, InterfaceC0237sP interfaceC0237sP) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                context.startActivity(intent);
                if (interfaceC0237sP == null) {
                    return true;
                }
                interfaceC0237sP.Sj();
                return true;
            } catch (Throwable th2) {
                if (interfaceC0237sP != null) {
                    interfaceC0237sP.Sj(th2);
                }
            }
        }
        return false;
    }
}
