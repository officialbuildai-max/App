package com.cloud.hisavana.sdk;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.common.activity.AdvertiserLinkActivity;
import com.cloud.hisavana.sdk.common.activity.PersonalCloseAdActivity;
import com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuContentView;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuItemView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.lang.ref.WeakReference;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public class t2 {

    /* renamed from: a, reason: collision with root package name */
    private long f23025a = 0;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference f23026b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f23027c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f23028a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdsDTO f23029b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f23030c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f23031d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdCloseView f23032e;

        a(Object obj, AdsDTO adsDTO, boolean z10, Context context, AdCloseView adCloseView) {
            this.f23028a = obj;
            this.f23029b = adsDTO;
            this.f23030c = z10;
            this.f23031d = context;
            this.f23032e = adCloseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e4.b().d("ssp", "registerCloseAd ---- >  " + this.f23028a);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - t2.this.f23025a < 2000) {
                e4.b().d("ssp", "registerCloseAd ---- > interval time not reached");
                return;
            }
            t2.this.f23025a = currentTimeMillis;
            if (this.f23028a == null) {
                return;
            }
            if (this.f23029b.getSource() == 4 || this.f23030c) {
                t2.this.m(this.f23028a);
                return;
            }
            if (t2.this.o(this.f23031d, this.f23028a, this.f23029b, this.f23032e)) {
                t2.this.q(this.f23028a);
                if (!(this.f23028a instanceof i1) || this.f23029b.getDisplayRule() == Constants.AdDisplayRule.RU) {
                    return;
                }
                ((i1) this.f23028a).O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23034a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f23035b;

        static {
            int[] iArr = new int[AdExpandMenuItemView.Type.values().length];
            f23035b = iArr;
            try {
                iArr[AdExpandMenuItemView.Type.PERSONALISE_CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23035b[AdExpandMenuItemView.Type.ADVERTISER_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23035b[AdExpandMenuItemView.Type.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Constants.AdDisplayRule.values().length];
            f23034a = iArr2;
            try {
                iArr2[Constants.AdDisplayRule.RU.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23034a[Constants.AdDisplayRule.UNIVERSAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final t2 f23036a = new t2();
    }

    private void i(Context context, Object obj, AdsDTO adsDTO) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("tag_ad_bean", adsDTO);
        bundle.putInt("close_hash_code", obj == null ? 0 : obj.hashCode());
        Intent intent = new Intent(context, (Class<?>) PersonalCloseAdActivity.class);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.setFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    private void j(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) AdvertiserLinkActivity.class);
        intent.putExtra("url", str);
        if (!(context instanceof Activity)) {
            intent.setFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void h(AdExpandMenuItemView.Type type, Context context, AdsDTO adsDTO, Object obj) {
        if (context == null || adsDTO == null || obj == null) {
            return;
        }
        int i11 = b.f23035b[type.ordinal()];
        if (i11 == 1) {
            i(context, obj, adsDTO);
            if (obj instanceof i1) {
                ((i1) obj).O();
                return;
            }
            return;
        }
        if (i11 == 2) {
            j(context, com.cloud.hisavana.sdk.common.util.f0.b(adsDTO));
            if (obj instanceof i1) {
                ((i1) obj).O();
                return;
            }
            return;
        }
        if (i11 != 3) {
            return;
        }
        try {
            Object systemService = context.getSystemService("clipboard");
            if (systemService instanceof ClipboardManager) {
                ClipboardManager clipboardManager = (ClipboardManager) systemService;
                ClipData newPlainText = ClipData.newPlainText(context.getString(R$string.copy_link), com.cloud.hisavana.sdk.common.util.f0.d(adsDTO));
                if (newPlainText != null) {
                    clipboardManager.setPrimaryClip(newPlainText);
                    Toast.makeText(context, context.getString(R$string.copy_successfully), 0).show();
                }
            }
        } catch (Exception e11) {
            e4.b().e("ssp", Log.getStackTraceString(e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Object obj) {
        TaNativeInfo taNativeInfo;
        if (obj == null) {
            return;
        }
        if (obj instanceof i1) {
            ((i1) obj).B0();
            return;
        }
        if (obj instanceof p3) {
            ((p3) obj).P();
            return;
        }
        if (!(obj instanceof u3)) {
            if (obj instanceof TAdInterstitialActivity) {
                ((TAdInterstitialActivity) obj).L0();
            }
        } else {
            WeakReference weakReference = this.f23027c;
            if (weakReference == null || (taNativeInfo = (TaNativeInfo) weakReference.get()) == null) {
                return;
            }
            ((u3) obj).R(taNativeInfo);
        }
    }

    public static t2 p() {
        return c.f23036a;
    }

    public void d() {
        Object obj;
        WeakReference weakReference = this.f23026b;
        if (weakReference == null || (obj = weakReference.get()) == null) {
            return;
        }
        m(obj);
    }

    public void e(int i11) {
        Object obj;
        WeakReference weakReference = this.f23026b;
        if (weakReference == null || (obj = weakReference.get()) == null || obj.hashCode() != i11) {
            return;
        }
        m(obj);
    }

    public void f(Context context, AdCloseView adCloseView, Object obj, AdsDTO adsDTO) {
        g(context, adCloseView, obj, adsDTO, false);
    }

    public void g(Context context, AdCloseView adCloseView, Object obj, AdsDTO adsDTO, boolean z10) {
        if (adCloseView == null || adsDTO == null) {
            return;
        }
        e4.b().d("ssp", "AdCloseManager -------> registerCloseAd ---- >");
        adCloseView.setVisibility(0);
        adCloseView.setOnClickListener(new a(obj, adsDTO, z10, context, adCloseView));
    }

    public void n(Object obj, TaNativeInfo taNativeInfo) {
        this.f23026b = new WeakReference(obj);
        this.f23027c = new WeakReference(taNativeInfo);
    }

    public boolean o(final Context context, final Object obj, final AdsDTO adsDTO, AdCloseView adCloseView) {
        if (context != null && adsDTO != null) {
            int i11 = b.f23034a[adsDTO.getDisplayRule().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    i(context, obj, adsDTO);
                }
            } else if (obj != null && adCloseView != null) {
                PopupWindow i12 = com.cloud.hisavana.sdk.common.widget.expandmenu.c.i(adCloseView, com.cloud.hisavana.sdk.common.util.f0.a(adsDTO), new AdExpandMenuContentView.d() { // from class: com.cloud.hisavana.sdk.s2
                    @Override // com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuContentView.d
                    public final void a(AdExpandMenuItemView.Type type) {
                        t2.this.h(context, adsDTO, obj, type);
                    }
                });
                if (obj instanceof i1) {
                    ((i1) obj).c0(i12);
                }
            }
            return true;
        }
        return false;
    }

    public void q(Object obj) {
        this.f23026b = new WeakReference(obj);
    }

    public long r() {
        return this.f23025a;
    }
}
