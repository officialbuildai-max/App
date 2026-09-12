package com.transsion.audio.view;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.therouter.TheRouter;
import com.transsion.audio.fragment.AudioBottomSheetFragment;
import com.transsion.audio.view.EnFloatingView;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private FloatingMagnetView f43007a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference f43008b;

    /* renamed from: c, reason: collision with root package name */
    private final List f43009c;

    /* renamed from: d, reason: collision with root package name */
    private String f43010d;

    /* renamed from: e, reason: collision with root package name */
    private AudioBean f43011e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements EnFloatingView.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f43012a;

        a(FrameLayout frameLayout) {
            this.f43012a = frameLayout;
        }

        @Override // com.transsion.audio.view.EnFloatingView.f
        public void a(ViewGroup viewGroup) {
            d dVar = d.this;
            dVar.i((ViewGroup) dVar.f43008b.get());
            for (IFloatingApi.a aVar : d.this.f43009c) {
                if (aVar != null) {
                    aVar.onRemove();
                }
            }
            d.this.w(8);
        }

        @Override // com.transsion.audio.view.EnFloatingView.f
        public void b(ViewGroup viewGroup) {
            AudioBottomSheetFragment.INSTANCE.a(d.this.f43011e).show(((FragmentActivity) this.f43012a.getContext()).getSupportFragmentManager(), "dialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f43014a = new d();
    }

    private d() {
        this.f43010d = "";
        this.f43011e = null;
        this.f43009c = new ArrayList();
    }

    private void e(View view) {
        FrameLayout n11;
        if (n() == null || (n11 = n()) == null) {
            return;
        }
        n11.addView(view);
    }

    private void j(Activity activity, AudioBean audioBean) {
        if (this.f43007a == null) {
            EnFloatingView enFloatingView = new EnFloatingView(activity);
            this.f43007a = enFloatingView;
            e(enFloatingView);
        } else {
            w(0);
            if (!((IAudioApi) TheRouter.d(IAudioApi.class, new Object[0])).b(audioBean) && this.f43007a.isPackUp()) {
                this.f43007a.expanded();
            }
        }
    }

    public static d k() {
        return b.f43014a;
    }

    private FrameLayout l(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(R.id.content);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private FrameLayout n() {
        WeakReference weakReference = this.f43008b;
        if (weakReference == null) {
            return null;
        }
        return (FrameLayout) weakReference.get();
    }

    public d d(Activity activity, AudioBean audioBean) {
        j(activity, audioBean);
        return this;
    }

    public d f(Activity activity) {
        g(activity, l(activity));
        return this;
    }

    public void g(Activity activity, FrameLayout frameLayout) {
        FloatingMagnetView floatingMagnetView;
        String simpleName = activity.getClass().getSimpleName();
        if (!TextUtils.equals(this.f43010d, simpleName)) {
            this.f43010d = simpleName;
            FloatingMagnetView floatingMagnetView2 = this.f43007a;
            if (floatingMagnetView2 != null) {
                floatingMagnetView2.packUp();
            }
        }
        if (frameLayout == null || (floatingMagnetView = this.f43007a) == null) {
            this.f43008b = new WeakReference(frameLayout);
            return;
        }
        floatingMagnetView.setOnOptionListener(new a(frameLayout));
        if (this.f43007a.getParent() == frameLayout) {
            return;
        }
        if (this.f43007a.getParent() != null) {
            ((ViewGroup) this.f43007a.getParent()).removeView(this.f43007a);
        }
        this.f43007a.attach(activity);
        this.f43008b = new WeakReference(frameLayout);
        frameLayout.addView(this.f43007a);
    }

    public d h(Activity activity) {
        i(l(activity));
        return this;
    }

    public void i(ViewGroup viewGroup) {
        FloatingMagnetView floatingMagnetView = this.f43007a;
        if (floatingMagnetView != null && viewGroup != null && ViewCompat.isAttachedToWindow(floatingMagnetView)) {
            viewGroup.removeView(this.f43007a);
        }
        if (n() == viewGroup) {
            this.f43008b = null;
        }
    }

    public AudioBean m() {
        return this.f43011e;
    }

    public Boolean o() {
        return Boolean.valueOf(this.f43007a.getVisibility() == 8);
    }

    public d p(Long l11, Long l12) {
        if (this.f43007a != null) {
            int longValue = (int) (((((float) l11.longValue()) * 1.0f) / ((float) l12.longValue())) * 100.0f);
            if (longValue > 100) {
                longValue = 100;
            }
            this.f43007a.onProgress(longValue);
        }
        return this;
    }

    public d q(int i11) {
        FloatingMagnetView floatingMagnetView = this.f43007a;
        if (floatingMagnetView != null) {
            floatingMagnetView.onStateChanged(i11);
        }
        return this;
    }

    public void r() {
        FloatingMagnetView floatingMagnetView = this.f43007a;
        if (floatingMagnetView != null) {
            floatingMagnetView.packUp();
        }
    }

    public void s() {
        FloatingMagnetView floatingMagnetView = this.f43007a;
        if (floatingMagnetView != null) {
            floatingMagnetView.packUpAnimation();
        }
    }

    public d t(AudioBean audioBean) {
        if (audioBean != null) {
            this.f43011e = audioBean;
            lg.a.f68962a.c("EnFloatingView", "prepare..mEnFloatingView.." + this.f43007a, false);
            FloatingMagnetView floatingMagnetView = this.f43007a;
            if (floatingMagnetView != null) {
                floatingMagnetView.prepare();
            }
        }
        return this;
    }

    public void u(IFloatingApi.a aVar) {
        this.f43009c.remove(aVar);
    }

    public void v(IFloatingApi.a aVar) {
        this.f43009c.add(aVar);
    }

    public d w(int i11) {
        FloatingMagnetView floatingMagnetView = this.f43007a;
        if (floatingMagnetView != null && floatingMagnetView.getVisibility() != i11) {
            this.f43007a.setVisibility(i11);
        }
        return this;
    }

    public void x(String str) {
        m().setTitle(str);
    }
}
