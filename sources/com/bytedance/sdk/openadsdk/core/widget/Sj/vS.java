package com.bytedance.sdk.openadsdk.core.widget.Sj;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.LqL;
import com.bytedance.sdk.openadsdk.Zq.Sj.Sj;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.sef;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class vS implements LqL.Sj {
    boolean Dq;
    WebView EjP;
    float Fmk;
    boolean Jcg;
    private long LD;
    long RiZ;
    Context Sj;
    int TEQ;
    boolean TzV;
    float Ym;
    float Zq;

    /* renamed from: aa, reason: collision with root package name */
    float f21187aa;
    boolean dNu;
    private boolean fF;
    private final boolean ley;
    sU sP;
    float sef;
    String uA;
    long uvD;
    private final Handler wE = new LqL(sef.sP().getLooper(), this);
    String TKC = "landingpage";
    int vS = 0;
    private final String LqL = ".*\\/serp\\?sc=.*&clkt=\\d+$";
    private final String Yf = ".*\\/\\?caf_results=.*&clkt=\\d+$";
    Sj kF = new Sj() { // from class: com.bytedance.sdk.openadsdk.core.widget.Sj.vS.1
        @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.vS.Sj
        public void Sj() {
            vS vSVar = vS.this;
            vSVar.Dq = true;
            vSVar.vS();
            vS vSVar2 = vS.this;
            vSVar2.Sj(2, vSVar2.uA, vSVar2.TEQ);
        }
    };
    GestureDetector uP = new GestureDetector(dNu.Sj(), new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.Sj.vS.2
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            vS.this.dNu = true;
            return false;
        }
    });
    int HiB = dNu.EjP().Ir();
    Map<Integer, Long> sU = new HashMap();

    /* renamed from: dx, reason: collision with root package name */
    Map<Integer, Float> f21188dx = new HashMap();
    Map<Integer, Long> zR = new HashMap();

    /* renamed from: ib, reason: collision with root package name */
    List<Integer> f21189ib = new ArrayList();

    /* loaded from: classes3.dex */
    public interface Sj {
        void Sj();
    }

    public vS(WebView webView, sU sUVar, Context context, boolean z10) {
        this.sP = sUVar;
        this.EjP = webView;
        this.Sj = context;
        this.ley = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() {
        WebBackForwardList copyBackForwardList = this.EjP.copyBackForwardList();
        if (copyBackForwardList != null) {
            int currentIndex = copyBackForwardList.getCurrentIndex();
            this.TEQ = currentIndex + 1;
            if (this.ley) {
                this.TEQ = currentIndex + 2;
            }
        }
    }

    private void EjP() {
        if (Jcg()) {
            return;
        }
        com.bytedance.sdk.openadsdk.Zq.Sj.Sj Sj2 = new Sj.C0253Sj().Sj(this.uA).Sj(this.TEQ).EjP(this.Ym).HiB(this.f21187aa).vS(this.Zq).Jcg((float) this.RiZ).Sj();
        Message obtain = Message.obtain();
        obtain.what = 100;
        obtain.obj = Sj2;
        this.wE.sendMessageDelayed(obtain, 20L);
    }

    private void EjP(String str) {
        if (Jcg()) {
            return;
        }
        com.bytedance.sdk.openadsdk.EjP.TKC.Sj(this.sP, new Sj.C0253Sj().Sj(this.uA).sP(Uri.decode(str)).Sj(), this.TKC);
    }

    private boolean HiB() {
        try {
            int i11 = this.TEQ;
            if (i11 != 2 && i11 != 3) {
                return false;
            }
            if (Pattern.matches(".*\\/serp\\?sc=.*&clkt=\\d+$", this.uA)) {
                return true;
            }
            return Pattern.matches(".*\\/\\?caf_results=.*&clkt=\\d+$", this.uA);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.sP("WebArbitrageBehavior", th2.toString());
            return false;
        }
    }

    private boolean Jcg() {
        int i11 = this.vS + 1;
        this.vS = i11;
        if (i11 > this.HiB) {
            return true;
        }
        return ("landingpage".equals(this.TKC) || "landingpage_endcard".equals(this.TKC) || "landingpage_split_screen".equals(this.TKC) || "landingpage_direct".equals(this.TKC) || "landingpage_split_ceiling".equals(this.TKC)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(int i11, String str, int i12) {
        if (Jcg()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l11 = this.sU.get(Integer.valueOf(i12));
        long longValue = l11 != null ? l11.longValue() : elapsedRealtime;
        Float f11 = this.f21188dx.get(Integer.valueOf(i12));
        com.bytedance.sdk.openadsdk.EjP.TKC.TKC(this.sP, new Sj.C0253Sj().Sj(str).Sj(i12).Dq((float) (elapsedRealtime - longValue)).uA(f11 == null ? 0.0f : f11.floatValue()).sP(i11).Sj(), this.TKC);
    }

    private void TKC(int i11) {
        if (Jcg()) {
            return;
        }
        vS();
        this.Jcg = true;
        com.bytedance.sdk.openadsdk.Zq.Sj.Sj Sj2 = new Sj.C0253Sj().Sj(this.uA).Sj(this.TEQ).Sj(this.Ym).sP(this.f21187aa).TKC((float) this.RiZ).TKC(i11).Sj();
        try {
            if (this.fF) {
                WebView.HitTestResult hitTestResult = this.EjP.getHitTestResult();
                Sj2.Sj(hitTestResult.getExtra());
                Sj2.Sj(hitTestResult.getType());
            }
        } catch (Throwable unused) {
        }
        Message obtain = Message.obtain();
        obtain.what = 200;
        obtain.obj = Sj2;
        this.wE.sendMessageDelayed(obtain, 100L);
    }

    private void sP(int i11) {
        if (Jcg() || this.f21189ib.contains(Integer.valueOf(i11))) {
            return;
        }
        this.f21189ib.add(Integer.valueOf(i11));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l11 = this.zR.get(Integer.valueOf(i11));
        com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.sP, new Sj.C0253Sj().Sj(this.uA).Sj(this.TEQ).TEQ((float) (elapsedRealtime - (l11 != null ? l11.longValue() : elapsedRealtime))).Sj(), this.TKC);
    }

    private boolean sP(MotionEvent motionEvent) {
        this.Fmk = motionEvent.getX();
        float y10 = motionEvent.getY();
        this.sef = y10;
        float f11 = this.f21187aa;
        if (y10 - f11 == 0.0f) {
            return false;
        }
        this.Zq = y10 - f11;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS() {
        if (this.f21188dx.get(Integer.valueOf(this.TEQ)) != null) {
            return;
        }
        float height = this.EjP.getHeight() / FPG.sP(this.Sj, this.EjP.getContentHeight());
        if (height < 0.0f || height > 1.0f) {
            height = 0.0f;
        }
        this.f21188dx.put(Integer.valueOf(this.TEQ), Float.valueOf(height));
    }

    public void Sj() {
        sP(this.TEQ);
    }

    public void Sj(int i11) {
        float height = (i11 + this.EjP.getHeight()) / FPG.sP(this.Sj, this.EjP.getContentHeight());
        Float f11 = this.f21188dx.get(Integer.valueOf(this.TEQ));
        if (height > (f11 == null ? 0.0f : f11.floatValue())) {
            this.f21188dx.put(Integer.valueOf(this.TEQ), Float.valueOf(height));
        }
    }

    @Override // com.bytedance.sdk.component.utils.LqL.Sj
    public void Sj(Message message) {
        int i11 = message.what;
        com.bytedance.sdk.openadsdk.Zq.Sj.Sj sj2 = (com.bytedance.sdk.openadsdk.Zq.Sj.Sj) message.obj;
        if (i11 == 100) {
            sj2.EjP(this.dNu ? 2 : 1);
            com.bytedance.sdk.openadsdk.EjP.TKC.EjP(this.sP, sj2, this.TKC);
            this.dNu = false;
        } else if (i11 == 200) {
            if (this.TzV) {
                Sj(1, sj2.TKC(), sj2.EjP());
            }
            sj2.TKC(this.TzV ? 1 : 0);
            com.bytedance.sdk.openadsdk.EjP.TKC.HiB(this.sP, sj2, this.TKC);
            this.Jcg = false;
            this.TzV = false;
        }
    }

    public void Sj(MotionEvent motionEvent) {
        this.uP.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Ym = motionEvent.getX();
            this.f21187aa = motionEvent.getY();
            this.uvD = SystemClock.elapsedRealtime();
        } else if (action != 1) {
            if (action != 3) {
                return;
            }
            TKC(2);
        } else {
            this.RiZ = SystemClock.elapsedRealtime() - this.uvD;
            if (sP(motionEvent)) {
                EjP();
            } else {
                TKC(1);
            }
        }
    }

    public void Sj(String str) {
        this.TKC = str;
    }

    public Sj TKC() {
        return this.kF;
    }

    public void TKC(String str) {
        if (this.Jcg) {
            this.TzV = true;
        }
        if (this.TEQ == 1 && !TextUtils.isEmpty(str) && str.contains("query=")) {
            int indexOf = str.indexOf("query=") + 6;
            int indexOf2 = str.indexOf(UrlUtils.AND_MARK, indexOf);
            if (indexOf < 0 || indexOf2 >= str.length() || indexOf2 <= indexOf) {
                return;
            }
            EjP(str.substring(indexOf, indexOf2));
        }
    }

    public void sP() {
        this.EjP.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.Sj.vS.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z10) {
                if (!z10) {
                    vS vSVar = vS.this;
                    if (!vSVar.Dq) {
                        vSVar.vS();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (elapsedRealtime - vS.this.LD >= 50) {
                            vS vSVar2 = vS.this;
                            vSVar2.Sj(3, vSVar2.uA, vSVar2.TEQ);
                            vS.this.LD = elapsedRealtime;
                            return;
                        }
                        return;
                    }
                    vSVar.Dq = false;
                }
                if (z10) {
                    vS.this.Dq();
                    vS vSVar3 = vS.this;
                    vSVar3.sU.put(Integer.valueOf(vSVar3.TEQ), Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        });
    }

    public void sP(String str) {
        this.uA = str;
        Dq();
        this.sU.put(Integer.valueOf(this.TEQ), Long.valueOf(SystemClock.elapsedRealtime()));
        this.zR.put(Integer.valueOf(this.TEQ), Long.valueOf(SystemClock.elapsedRealtime()));
        this.fF = HiB();
    }
}
