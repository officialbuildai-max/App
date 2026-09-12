package com.transsion.shorttv_pugc.base.widget.expand;

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
import com.transsion.shorttv_pugc.base.widget.TnTextView;
import com.transsion.shorttv_pugc.base.widget.expand.ExpandView;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public class ExpandView extends TnTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private String A;
    private String B;
    private boolean C;

    /* renamed from: b, reason: collision with root package name */
    private String f53923b;

    /* renamed from: c, reason: collision with root package name */
    private String f53924c;

    /* renamed from: d, reason: collision with root package name */
    private String f53925d;

    /* renamed from: e, reason: collision with root package name */
    private String f53926e;

    /* renamed from: f, reason: collision with root package name */
    private String f53927f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f53928g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f53929h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f53930i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f53931j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f53932k;

    /* renamed from: l, reason: collision with root package name */
    private int f53933l;

    /* renamed from: m, reason: collision with root package name */
    private int f53934m;

    /* renamed from: n, reason: collision with root package name */
    private int f53935n;

    /* renamed from: o, reason: collision with root package name */
    private int f53936o;

    /* renamed from: p, reason: collision with root package name */
    private int f53937p;

    /* renamed from: q, reason: collision with root package name */
    private int f53938q;

    /* renamed from: r, reason: collision with root package name */
    private int f53939r;

    /* renamed from: s, reason: collision with root package name */
    private float f53940s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f53941t;

    /* renamed from: u, reason: collision with root package name */
    private ClickableSpan f53942u;

    /* renamed from: v, reason: collision with root package name */
    private jt.a f53943v;

    /* renamed from: w, reason: collision with root package name */
    private jt.a f53944w;

    /* renamed from: x, reason: collision with root package name */
    private Layout f53945x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f53946y;

    /* renamed from: z, reason: collision with root package name */
    private c f53947z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ExpandView expandView = ExpandView.this;
            expandView.l(expandView.f53946y);
            ExpandView.this.f53932k = true;
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
        this.f53926e = "  ";
        this.f53927f = "  ";
        this.f53928g = false;
        this.f53929h = true;
        this.f53930i = true;
        this.f53931j = true;
        this.f53932k = false;
        this.f53933l = 1;
        this.f53934m = -1711276033;
        this.f53935n = -1711276033;
        this.f53936o = 0;
        this.f53937p = 0;
        this.f53938q = -1;
        this.f53939r = 0;
        this.f53941t = true;
        this.C = false;
        j(context, attributeSet);
    }

    public ExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f53926e = "  ";
        this.f53927f = "  ";
        this.f53928g = false;
        this.f53929h = true;
        this.f53930i = true;
        this.f53931j = true;
        this.f53932k = false;
        this.f53933l = 1;
        this.f53934m = -1711276033;
        this.f53935n = -1711276033;
        this.f53936o = 0;
        this.f53937p = 0;
        this.f53938q = -1;
        this.f53939r = 0;
        this.f53941t = true;
        this.C = false;
        j(context, attributeSet);
    }

    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private CharSequence h(int i11) {
        int i12;
        TextPaint paint = getPaint();
        String str = "";
        if (this.f53946y != null) {
            str = "" + ((Object) this.f53946y);
        }
        if (this.f53945x == null) {
            this.f53945x = new StaticLayout(str, paint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.f53945x.getLineCount();
        int i13 = this.f53933l;
        if (lineCount <= i13) {
            CharSequence charSequence = this.f53946y;
            if (charSequence == null) {
                charSequence = " ";
            }
            return n(new SpannableStringBuilder(charSequence));
        }
        int i14 = this.f53939r;
        if (i14 != 0) {
            if (i14 != 1 || !this.f53931j) {
                return n(new SpannableStringBuilder(this.f53946y));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f53946y);
            spannableStringBuilder.append((CharSequence) this.f53927f).append((CharSequence) this.f53925d);
            int length = (spannableStringBuilder.length() - this.f53927f.length()) - this.f53925d.length();
            int length2 = spannableStringBuilder.length();
            i12 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.f53942u, i12, length2, 33);
            spannableStringBuilder.setSpan(this.f53943v, i12, length2, 33);
            return n(spannableStringBuilder);
        }
        int lineEnd = this.f53945x.getLineEnd(i13 - 1);
        this.f53945x.getLineStart(this.f53933l - 1);
        CharSequence charSequence2 = this.f53946y;
        if (charSequence2 != null && charSequence2.length() <= lineEnd) {
            lineEnd = this.f53946y.length() - 1;
        }
        CharSequence charSequence3 = this.f53946y;
        if (charSequence3 == null || lineEnd <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder((charSequence3.subSequence(0, Math.max(0, lineEnd - 3)).toString() + this.f53923b).replace("\n\n", "\n"));
        if (this.f53930i) {
            spannableStringBuilder2.append((CharSequence) this.f53926e);
            spannableStringBuilder2.append((CharSequence) this.f53924c);
            int length3 = (spannableStringBuilder2.length() - this.f53926e.length()) - this.f53924c.length();
            int length4 = spannableStringBuilder2.length();
            i12 = length3 >= 0 ? length3 : 0;
            spannableStringBuilder2.setSpan(this.f53942u, i12, length4, 33);
            spannableStringBuilder2.setSpan(this.f53944w, i12, length4, 33);
        }
        return n(spannableStringBuilder2);
    }

    private void i() {
        if (this.f53940s == 0.0f) {
            this.f53940s = getTextSize();
        }
        boolean z10 = getLayoutDirection() == 1;
        this.f53944w = new jt.a(getContext(), this.f53941t ? R$mipmap.short_tv_ic_down_more : -111, this.f53934m, this.f53936o, this.f53940s, 0, z10);
        this.f53943v = new jt.a(getContext(), this.f53941t ? R$mipmap.short_tv_ic_up_hide : -111, this.f53935n, this.f53937p, this.f53940s, 0, z10);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.f53923b)) {
            this.f53923b = "...";
        }
        if (TextUtils.isEmpty(this.f53924c)) {
            this.f53924c = getResources().getString(R$string.short_tv_str_more);
        }
        if (TextUtils.isEmpty(this.f53925d)) {
            this.f53925d = "\n" + getResources().getString(R$string.short_tv_str_hide);
        }
        if (this.f53926e == null) {
            this.f53926e = "  ";
        }
        if (this.f53927f == null) {
            this.f53927f = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: jt.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandView.this.k(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void j(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            i();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ExpandView_pop_hint_text_size) {
                this.f53940s = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.ExpandView_pop_reverse_Lines) {
                this.f53933l = obtainStyledAttributes.getInteger(index, 1);
            } else if (index == R$styleable.ExpandView_pop_ellipsis) {
                this.f53923b = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_expand_hint) {
                this.f53924c = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint) {
                this.f53925d = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_toggle_enabled) {
                this.f53928g = obtainStyledAttributes.getBoolean(index, this.f53928g);
            } else if (index == R$styleable.ExpandView_pop_show_expand_hint) {
                this.f53930i = obtainStyledAttributes.getBoolean(index, this.f53930i);
            } else if (index == R$styleable.ExpandView_pop_show_shrink_hint) {
                this.f53931j = obtainStyledAttributes.getBoolean(index, this.f53931j);
            } else if (index == R$styleable.ExpandView_pop_expand_hint_color) {
                this.f53934m = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint_color) {
                this.f53935n = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_expand_bg_Color) {
                this.f53936o = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_shrink_bg_color) {
                this.f53937p = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_Init_state) {
                this.f53939r = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_expand_gap) {
                this.f53926e = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_collapse_gap) {
                this.f53927f = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_hash_tag_color) {
                this.f53938q = obtainStyledAttributes.getInteger(index, this.f53938q);
            } else if (index == R$styleable.ExpandView_pop_show_hint_icon) {
                this.f53941t = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence m(final CharSequence charSequence) {
        if (!this.f53929h) {
            return charSequence;
        }
        if (!TextUtils.equals(charSequence, this.f53946y)) {
            this.f53945x = null;
        }
        this.f53946y = charSequence;
        int layoutWidth = getLayoutWidth();
        if (layoutWidth > 0) {
            this.C = true;
            return this.f53946y == null ? charSequence : h(layoutWidth);
        }
        if (this.f53932k) {
            postDelayed(new Runnable() { // from class: jt.d
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandView.this.l(charSequence);
                }
            }, 100L);
        }
        return null;
    }

    private CharSequence n(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void o() {
        if (getText().toString().contains(this.f53924c) || getText().toString().contains(this.f53925d)) {
            int i11 = this.f53939r;
            if (i11 == 0) {
                this.f53939r = 1;
                c cVar = this.f53947z;
                if (cVar != null) {
                    cVar.a(this);
                }
            } else if (i11 == 1) {
                this.f53939r = 0;
                c cVar2 = this.f53947z;
                if (cVar2 != null) {
                    cVar2.b(this);
                }
            }
            l(this.f53946y);
        }
    }

    public void addLegacyHashTag(String str, String str2) {
        this.B = str;
        this.A = str2;
    }

    @Override // com.transsion.shorttv_pugc.base.widget.TnTextView, ft.a
    public void changeLocal() {
        this.f53924c = getResources().getString(R$string.short_tv_str_more);
        this.f53925d = getResources().getString(R$string.short_tv_str_hide);
        super.changeLocal();
    }

    public int getExpandState() {
        return this.f53939r;
    }

    public boolean isOutLines() {
        Layout layout = this.f53945x;
        return layout != null && layout.getLineCount() > this.f53933l;
    }

    public boolean isSetTitleSuccess() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.f53939r = 0;
        c cVar = this.f53947z;
        if (cVar != null) {
            cVar.b(this);
        }
        l(this.f53946y);
    }

    public void setCollapseEnable(boolean z10) {
        this.f53929h = z10;
    }

    public void setExpandListener(c cVar) {
        this.f53947z = cVar;
    }

    public void setOnClickHashTagListener(b bVar) {
    }

    /* renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void l(final CharSequence charSequence) {
        setTextAction(new Function0() { // from class: jt.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CharSequence m11;
                m11 = ExpandView.this.m(charSequence);
                return m11;
            }
        });
    }
}
