package com.transsion.subtitle.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class j implements View.OnTouchListener {

    /* renamed from: o, reason: collision with root package name */
    public static final a f55041o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f55042a;

    /* renamed from: b, reason: collision with root package name */
    private eu.a f55043b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f55044c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f55045d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f55046e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f55047f;

    /* renamed from: h, reason: collision with root package name */
    private float f55049h;

    /* renamed from: i, reason: collision with root package name */
    private Function2 f55050i;

    /* renamed from: j, reason: collision with root package name */
    private Function0 f55051j;

    /* renamed from: k, reason: collision with root package name */
    private long f55052k;

    /* renamed from: l, reason: collision with root package name */
    private float f55053l;

    /* renamed from: g, reason: collision with root package name */
    private Handler f55048g = new Handler(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f55054m = new Runnable() { // from class: com.transsion.subtitle.helper.i
        @Override // java.lang.Runnable
        public final void run() {
            j.s(j.this);
        }
    };

    /* renamed from: n, reason: collision with root package name */
    private final c f55055n = new c(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s11) {
            Editable text;
            Intrinsics.h(s11, "s");
            j.this.f55048g.removeCallbacks(j.this.f55054m);
            EditText editText = j.this.f55047f;
            if (editText == null || (text = editText.getText()) == null) {
                return;
            }
            j jVar = j.this;
            float m11 = j.m(jVar, text, 0.0f, 2, null);
            if (jVar.f55049h != m11) {
                jVar.f55049h = m11;
            }
            if (jVar.f55053l == m11) {
                return;
            }
            if (!StringsKt.G(text.toString(), "s", false, 2, null)) {
                EditText editText2 = jVar.f55047f;
                if (editText2 != null) {
                    editText2.setText(((Object) text) + "s");
                }
                EditText editText3 = jVar.f55047f;
                if (editText3 != null) {
                    editText3.setSelection(text.length());
                }
            }
            jVar.f55053l = m11;
            jVar.u(m11 * 1000);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s11, int i11, int i12, int i13) {
            Intrinsics.h(s11, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s11, int i11, int i12, int i13) {
            Intrinsics.h(s11, "s");
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.h(msg, "msg");
            super.handleMessage(msg);
            int i11 = msg.what;
            int i12 = msg.arg1;
            if (i11 == 1) {
                j.this.t(i12 == R$id.iv_sync_adjust_plus);
                sendMessageDelayed(obtainMessage(i11, msg.arg1, msg.arg2), 100L);
            }
        }
    }

    public j(ViewGroup viewGroup) {
        this.f55042a = viewGroup;
    }

    private final float l(CharSequence charSequence, float f11) {
        if (charSequence.length() == 0) {
            return f11;
        }
        String obj = charSequence.toString();
        if (StringsKt.G(obj, "s", false, 2, null)) {
            obj = obj.substring(0, obj.length() - 1);
            Intrinsics.g(obj, "substring(...)");
        }
        if (StringsKt.c0(obj, "s", false, 2, null)) {
            StringsKt.Q(obj, "s", "", false, 4, null);
        }
        try {
            return Float.parseFloat(obj);
        } catch (Throwable unused) {
            return f11;
        }
    }

    static /* synthetic */ float m(j jVar, CharSequence charSequence, float f11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = Float.NaN;
        }
        return jVar.l(charSequence, f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(j jVar, View view) {
        Function0 function0 = jVar.f55051j;
        if (function0 != null) {
            function0.invoke();
        }
        jVar.f55048g.removeCallbacks(jVar.f55054m);
        jVar.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(j jVar) {
        jVar.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(boolean z10) {
        float f11 = (z10 ? (this.f55049h * 1000.0f) + 100 : (this.f55049h * 1000.0f) - 100) / 1000.0f;
        this.f55049h = f11;
        EditText editText = this.f55047f;
        if (editText != null) {
            editText.setText(f11 + "s");
        }
        this.f55048g.removeCallbacks(this.f55054m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(long j11) {
        SubtitleDownloadTable b11;
        eu.a aVar = this.f55043b;
        if (aVar != null && (b11 = aVar.b()) != null) {
            b11.setDelay(Long.valueOf(j11));
        }
        Function2 function2 = this.f55050i;
        if (function2 != null) {
            function2.invoke(this.f55043b, Long.valueOf(j11));
        }
    }

    public final void n() {
        ViewGroup viewGroup = this.f55042a;
        if (viewGroup != null) {
            jg.c.g(viewGroup);
            KeyboardUtils.e(viewGroup);
        }
    }

    public final void o(Function2 function2) {
        this.f55050i = function2;
        ViewGroup viewGroup = this.f55042a;
        this.f55044c = viewGroup != null ? (ImageView) viewGroup.findViewById(R$id.iv_close) : null;
        ViewGroup viewGroup2 = this.f55042a;
        this.f55045d = viewGroup2 != null ? (ImageView) viewGroup2.findViewById(R$id.iv_sync_adjust_plus) : null;
        ViewGroup viewGroup3 = this.f55042a;
        this.f55046e = viewGroup3 != null ? (ImageView) viewGroup3.findViewById(R$id.iv_sync_adjust_minus) : null;
        ViewGroup viewGroup4 = this.f55042a;
        this.f55047f = viewGroup4 != null ? (EditText) viewGroup4.findViewById(R$id.et_sync_adjust) : null;
        ImageView imageView = this.f55044c;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.helper.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.p(j.this, view);
                }
            });
        }
        ImageView imageView2 = this.f55045d;
        if (imageView2 != null) {
            imageView2.setOnTouchListener(this);
        }
        ImageView imageView3 = this.f55046e;
        if (imageView3 != null) {
            imageView3.setOnTouchListener(this);
        }
        ImageView imageView4 = this.f55045d;
        if (imageView4 != null) {
            imageView4.setFocusable(true);
        }
        ImageView imageView5 = this.f55046e;
        if (imageView5 != null) {
            imageView5.setFocusable(true);
        }
        ImageView imageView6 = this.f55045d;
        if (imageView6 != null) {
            imageView6.setClickable(true);
        }
        ImageView imageView7 = this.f55046e;
        if (imageView7 != null) {
            imageView7.setClickable(true);
        }
        EditText editText = this.f55047f;
        if (editText != null) {
            editText.addTextChangedListener(new b());
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f55052k = System.currentTimeMillis();
            c cVar = this.f55055n;
            cVar.sendMessageDelayed(cVar.obtainMessage(1, view != null ? view.getId() : 0, 0), 1200L);
            if (view != null) {
                view.setPressed(true);
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this.f55055n.removeCallbacksAndMessages(null);
            if (System.currentTimeMillis() - this.f55052k <= 400) {
                t((view != null ? view.getId() : 0) == R$id.iv_sync_adjust_plus);
            }
            if (view != null) {
                view.setPressed(false);
            }
        }
        return true;
    }

    public final void q(Function2 callback) {
        Intrinsics.h(callback, "callback");
        this.f55050i = callback;
    }

    public final void r(eu.a aVar) {
        SubtitleDownloadTable b11;
        Long delay;
        this.f55043b = aVar;
        float longValue = ((float) ((aVar == null || (b11 = aVar.b()) == null || (delay = b11.getDelay()) == null) ? 0L : delay.longValue())) / 1000.0f;
        this.f55049h = longValue;
        this.f55053l = longValue;
        EditText editText = this.f55047f;
        if (editText != null) {
            editText.setText(longValue + "s");
        }
        com.transsion.subtitle.a.f54861a.a(j.class.getSimpleName() + " --> setCurDefVideoSubtitleBean() --> cur duration = " + this.f55049h);
    }
}
