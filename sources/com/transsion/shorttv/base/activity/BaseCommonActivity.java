package com.transsion.shorttv.base.activity;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import g4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import nh.m;
import nh.n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000 +*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u0001%B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH$¢\u0006\u0004\b\u0013\u0010\u0006J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u000f\u0010\u001e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\"\u0010*\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/transsion/shorttv/base/activity/BaseCommonActivity;", "Lg4/a;", "T", "Landroidx/appcompat/app/AppCompatActivity;", "Lnh/n;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "intercept", "(Landroid/content/Context;Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "getViewBinding", "()Lg4/a;", "setView", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onDisconnected", "onResume", "onPause", "finish", "onDestroy", "", "isMonitorNetworkState", "()Z", "", "getPageName", "()Ljava/lang/String;", "a", "Lg4/a;", "getMViewBinding", "setMViewBinding", "(Lg4/a;)V", "mViewBinding", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public abstract class BaseCommonActivity<T extends g4.a> extends AppCompatActivity implements n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public g4.a mViewBinding;

    @Override // android.app.Activity
    public void finish() {
        if (getIntent().getBooleanExtra(com.transsion.baseui.activity.BaseCommonActivity.EXTRA_SHOW_HOME_BUTTON, false)) {
            finishAffinity();
        }
        super.finish();
    }

    public final g4.a getMViewBinding() {
        g4.a aVar = this.mViewBinding;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.z("mViewBinding");
        return null;
    }

    public String getPageName() {
        return "";
    }

    public abstract g4.a getViewBinding();

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0001, B:7:0x0006, B:9:0x0014, B:15:0x0027, B:17:0x003a, B:19:0x0040, B:20:0x0046, B:22:0x004c, B:24:0x005b, B:26:0x0061, B:27:0x0067, B:29:0x0085, B:32:0x008a, B:39:0x0096, B:40:0x009d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void intercept(android.content.Context r9, android.os.Bundle r10) {
        /*
            r8 = this;
            r0 = 1
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1f
            if (r10 != 0) goto L6
            return
        L6:
            ih.b r1 = ih.b.f65364a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = r1.n()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = "9"
            boolean r2 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> L1f
            if (r2 != 0) goto L22
            java.lang.String r2 = "10"
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L1d
            goto L22
        L1d:
            r1 = 0
            goto L23
        L1f:
            r9 = move-exception
            goto La4
        L22:
            r1 = r0
        L23:
            if (r9 == 0) goto L9d
            if (r1 == 0) goto L9d
            java.lang.Class r1 = r9.getClass()     // Catch: java.lang.Throwable -> L1f
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            r10.setClassLoader(r1)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = "androidx.lifecycle.BundlableSavedStateRegistry.key"
            android.os.Bundle r10 = r10.getBundle(r1)     // Catch: java.lang.Throwable -> L1f
            if (r10 == 0) goto L96
            java.util.Set r1 = r10.keySet()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L96
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L1f
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1f
        L46:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L96
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r3 = r10.get(r2)     // Catch: java.lang.Throwable -> L1f
            boolean r4 = r3 instanceof android.os.Bundle     // Catch: java.lang.Throwable -> L1f
            r5 = 0
            if (r4 == 0) goto L5e
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L1f
            goto L5f
        L5e:
            r3 = r5
        L5f:
            if (r3 == 0) goto L66
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            goto L67
        L66:
            r3 = r5
        L67:
            lg.a$a r4 = lg.a.f68962a     // Catch: java.lang.Throwable -> L1f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r6.<init>()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r7 = "BaseCommonActivity --> intercept() --> classLoader = "
            r6.append(r7)     // Catch: java.lang.Throwable -> L1f
            r6.append(r3)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L1f
            r4.j(r3, r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r2 = r10.get(r2)     // Catch: java.lang.Throwable -> L1f
            boolean r3 = r2 instanceof android.os.Bundle     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L88
            r5 = r2
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch: java.lang.Throwable -> L1f
        L88:
            if (r5 == 0) goto L46
            java.lang.Class r2 = r9.getClass()     // Catch: java.lang.Throwable -> L1f
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            r5.setClassLoader(r2)     // Catch: java.lang.Throwable -> L1f
            goto L46
        L96:
            lg.a$a r9 = lg.a.f68962a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r10 = "BaseCommonActivity --> intercept() --> 当前系统版本9、10 替换BootClassLoader -- ClassLoader"
            r9.j(r10, r0)     // Catch: java.lang.Throwable -> L1f
        L9d:
            kotlin.Unit r9 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)     // Catch: java.lang.Throwable -> L1f
            goto Lae
        La4:
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.a(r9)
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)
        Lae:
            java.lang.Throwable r9 = kotlin.Result.m1188exceptionOrNullimpl(r9)
            if (r9 != 0) goto Lb5
            goto Lcb
        Lb5:
            lg.a$a r10 = lg.a.f68962a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "BaseCommonActivity --> intercept() --> it = "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r10.j(r9, r0)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.base.activity.BaseCommonActivity.intercept(android.content.Context, android.os.Bundle):void");
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // nh.n
    public void onConnected() {
        n.a.a(this);
    }

    @Override // nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        intercept(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        if (isMonitorNetworkState()) {
            m.f70597a.l(this);
        }
        setMViewBinding(getViewBinding());
        setView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isMonitorNetworkState()) {
            m.f70597a.m(this);
        }
        g.b(null, this, 1, null);
    }

    @Override // nh.n
    public void onDisconnected() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        g.g(null, this, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        g.k(null, this, 1, null);
    }

    public final void setMViewBinding(g4.a aVar) {
        Intrinsics.h(aVar, "<set-?>");
        this.mViewBinding = aVar;
    }

    protected abstract void setView();
}
