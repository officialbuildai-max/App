package com.transsion.shorttv.base.widget.expand;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.transsion.shorttv.R$mipmap;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.R$styleable;
import com.transsion.shorttv.base.widget.TnTextView;
import com.transsion.shorttv.base.widget.expand.ExpandView;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public class ExpandView extends TnTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private String A;
    private String B;

    /* renamed from: b, reason: collision with root package name */
    private String f52941b;

    /* renamed from: c, reason: collision with root package name */
    private String f52942c;

    /* renamed from: d, reason: collision with root package name */
    private String f52943d;

    /* renamed from: e, reason: collision with root package name */
    private String f52944e;

    /* renamed from: f, reason: collision with root package name */
    private String f52945f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f52946g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f52947h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f52948i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f52949j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f52950k;

    /* renamed from: l, reason: collision with root package name */
    private int f52951l;

    /* renamed from: m, reason: collision with root package name */
    private int f52952m;

    /* renamed from: n, reason: collision with root package name */
    private int f52953n;

    /* renamed from: o, reason: collision with root package name */
    private int f52954o;

    /* renamed from: p, reason: collision with root package name */
    private int f52955p;

    /* renamed from: q, reason: collision with root package name */
    private int f52956q;

    /* renamed from: r, reason: collision with root package name */
    private int f52957r;

    /* renamed from: s, reason: collision with root package name */
    private float f52958s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f52959t;

    /* renamed from: u, reason: collision with root package name */
    private ClickableSpan f52960u;

    /* renamed from: v, reason: collision with root package name */
    private es.a f52961v;

    /* renamed from: w, reason: collision with root package name */
    private es.a f52962w;

    /* renamed from: x, reason: collision with root package name */
    private Layout f52963x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f52964y;

    /* renamed from: z, reason: collision with root package name */
    private c f52965z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ExpandView expandView = ExpandView.this;
            expandView.setTitle(expandView.f52964y);
            ExpandView.this.f52950k = true;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(ExpandView expandView);

        void b(ExpandView expandView);
    }

    public ExpandView(Context context) {
        this(context, null);
    }

    public ExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52944e = "  ";
        this.f52945f = "  ";
        this.f52946g = false;
        this.f52947h = true;
        this.f52948i = true;
        this.f52949j = true;
        this.f52950k = false;
        this.f52951l = 1;
        this.f52952m = -1711276033;
        this.f52953n = -1711276033;
        this.f52954o = 872415231;
        this.f52955p = 872415231;
        this.f52956q = -1;
        this.f52957r = 0;
        this.f52959t = true;
        k(context, attributeSet);
    }

    public ExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f52944e = "  ";
        this.f52945f = "  ";
        this.f52946g = false;
        this.f52947h = true;
        this.f52948i = true;
        this.f52949j = true;
        this.f52950k = false;
        this.f52951l = 1;
        this.f52952m = -1711276033;
        this.f52953n = -1711276033;
        this.f52954o = 872415231;
        this.f52955p = 872415231;
        this.f52956q = -1;
        this.f52957r = 0;
        this.f52959t = true;
        k(context, attributeSet);
    }

    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private CharSequence h(int i11) {
        String str;
        int i12;
        TextPaint paint = getPaint();
        if (this.f52964y != null) {
            str = "" + ((Object) this.f52964y);
        } else {
            str = "";
        }
        if (this.f52963x == null) {
            this.f52963x = new StaticLayout(str, paint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.f52963x.getLineCount();
        int i13 = this.f52951l;
        if (lineCount <= i13) {
            CharSequence charSequence = this.f52964y;
            if (charSequence == null) {
                charSequence = " ";
            }
            return o(new SpannableStringBuilder(charSequence));
        }
        int i14 = this.f52957r;
        if (i14 != 0) {
            if (i14 != 1 || !this.f52949j) {
                return o(new SpannableStringBuilder(this.f52964y));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f52964y);
            spannableStringBuilder.append((CharSequence) this.f52945f).append((CharSequence) this.f52943d);
            int length = (spannableStringBuilder.length() - this.f52945f.length()) - this.f52943d.length();
            int length2 = spannableStringBuilder.length();
            i12 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.f52960u, i12, length2, 33);
            spannableStringBuilder.setSpan(this.f52961v, i12, length2, 33);
            return o(spannableStringBuilder);
        }
        int i15 = i(str, paint, this.f52963x.getLineStart(this.f52951l - 1), this.f52963x.getLineEnd(i13 - 1), i11);
        CharSequence charSequence2 = this.f52964y;
        if (charSequence2 != null && charSequence2.length() <= i15) {
            i15 = this.f52964y.length() - 1;
        }
        CharSequence charSequence3 = this.f52964y;
        if (charSequence3 == null || i15 <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder append = new SpannableStringBuilder(charSequence3.subSequence(0, i15)).append((CharSequence) this.f52941b);
        if (this.f52948i) {
            append.append((CharSequence) this.f52944e);
            append.append((CharSequence) this.f52942c);
            int length3 = (append.length() - this.f52944e.length()) - this.f52942c.length();
            int length4 = append.length();
            i12 = length3 >= 0 ? length3 : 0;
            append.setSpan(this.f52960u, i12, length4, 33);
            append.setSpan(this.f52962w, i12, length4, 33);
        }
        return o(append);
    }

    private int i(String str, TextPaint textPaint, int i11, int i12, int i13) {
        String str2;
        es.a aVar = this.f52962w;
        String str3 = this.f52941b;
        if (this.f52948i) {
            str2 = this.f52942c + this.f52944e;
        } else {
            str2 = "";
        }
        return textPaint.breakText(str, i11, i12, true, i13 - aVar.e(textPaint, str3, str2), null) + i11;
    }

    private void j() {
        if (this.f52958s == 0.0f) {
            this.f52958s = getTextSize();
        }
        boolean z10 = getLayoutDirection() == 1;
        this.f52962w = new es.a(getContext(), this.f52959t ? R$mipmap.short_tv_ic_down_more : -111, this.f52952m, this.f52954o, this.f52958s, 6, z10, 8);
        this.f52961v = new es.a(getContext(), this.f52959t ? R$mipmap.short_tv_ic_up_hide : -111, this.f52953n, this.f52955p, this.f52958s, 6, z10, 8);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.f52941b)) {
            this.f52941b = "...";
        }
        if (TextUtils.isEmpty(this.f52942c)) {
            this.f52942c = getResources().getString(R$string.short_tv_str_more);
        }
        if (TextUtils.isEmpty(this.f52943d)) {
            this.f52943d = getResources().getString(R$string.short_tv_str_hide);
        }
        if (this.f52944e == null) {
            this.f52944e = "  ";
        }
        if (this.f52945f == null) {
            this.f52945f = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: es.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandView.this.l(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void k(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            j();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ExpandView_pop_hint_text_size) {
                this.f52958s = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.ExpandView_pop_reverse_Lines) {
                this.f52951l = obtainStyledAttributes.getInteger(index, 1);
            } else if (index == R$styleable.ExpandView_pop_ellipsis) {
                this.f52941b = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_expand_hint) {
                this.f52942c = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint) {
                this.f52943d = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_toggle_enabled) {
                this.f52946g = obtainStyledAttributes.getBoolean(index, this.f52946g);
            } else if (index == R$styleable.ExpandView_pop_show_expand_hint) {
                this.f52948i = obtainStyledAttributes.getBoolean(index, this.f52948i);
            } else if (index == R$styleable.ExpandView_pop_show_shrink_hint) {
                this.f52949j = obtainStyledAttributes.getBoolean(index, this.f52949j);
            } else if (index == R$styleable.ExpandView_pop_expand_hint_color) {
                this.f52952m = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint_color) {
                this.f52953n = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_expand_bg_Color) {
                this.f52954o = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_shrink_bg_color) {
                this.f52955p = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_Init_state) {
                this.f52957r = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_expand_gap) {
                this.f52944e = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_collapse_gap) {
                this.f52945f = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_hash_tag_color) {
                this.f52956q = obtainStyledAttributes.getInteger(index, this.f52956q);
            } else if (index == R$styleable.ExpandView_pop_show_hint_icon) {
                this.f52959t = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(CharSequence charSequence) {
        if (this.f52950k) {
            setTitle(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence n(final CharSequence charSequence) {
        if (!this.f52947h) {
            return charSequence;
        }
        if (!TextUtils.equals(charSequence, this.f52964y)) {
            this.f52963x = null;
        }
        this.f52964y = charSequence;
        int layoutWidth = getLayoutWidth();
        if (layoutWidth > 0) {
            return this.f52964y == null ? charSequence : h(layoutWidth);
        }
        postDelayed(new Runnable() { // from class: es.d
            @Override // java.lang.Runnable
            public final void run() {
                ExpandView.this.m(charSequence);
            }
        }, 200L);
        return null;
    }

    private CharSequence o(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void p() {
        if (getText().toString().contains(this.f52942c) || getText().toString().contains(this.f52943d)) {
            int i11 = this.f52957r;
            if (i11 == 0) {
                this.f52957r = 1;
                c cVar = this.f52965z;
                if (cVar != null) {
                    cVar.a(this);
                }
            } else if (i11 == 1) {
                this.f52957r = 0;
                c cVar2 = this.f52965z;
                if (cVar2 != null) {
                    cVar2.b(this);
                }
            }
            setTitle(this.f52964y);
        }
    }

    public void addLegacyHashTag(String str, String str2) {
        this.B = str;
        this.A = str2;
    }

    @Override // com.transsion.shorttv.base.widget.TnTextView, bs.a
    public void changeLocal() {
        this.f52942c = getResources().getString(R$string.short_tv_str_more);
        this.f52943d = getResources().getString(R$string.short_tv_str_hide);
        super.changeLocal();
    }

    public int getExpandState() {
        return this.f52957r;
    }

    public boolean isOutLines() {
        Layout layout = this.f52963x;
        return layout != null && layout.getLineCount() > this.f52951l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.f52957r = 0;
        c cVar = this.f52965z;
        if (cVar != null) {
            cVar.b(this);
        }
        setTitle(this.f52964y);
    }

    public void setCollapseEnable(boolean z10) {
        this.f52947h = z10;
    }

    public void setExpandListener(c cVar) {
        this.f52965z = cVar;
    }

    public void setOnClickHashTagListener(b bVar) {
    }

    public void setTitle(final CharSequence charSequence) {
        setTextAction(new Function0() { // from class: es.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CharSequence n11;
                n11 = ExpandView.this.n(charSequence);
                return n11;
            }
        });
    }
}
