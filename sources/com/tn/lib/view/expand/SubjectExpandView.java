package com.tn.lib.view.expand;

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
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.expand.SubjectExpandView;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.R$styleable;

/* loaded from: classes4.dex */
public class SubjectExpandView extends AppCompatTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;

    /* renamed from: a, reason: collision with root package name */
    private String f41351a;

    /* renamed from: b, reason: collision with root package name */
    private String f41352b;

    /* renamed from: c, reason: collision with root package name */
    private String f41353c;

    /* renamed from: d, reason: collision with root package name */
    private String f41354d;

    /* renamed from: e, reason: collision with root package name */
    private String f41355e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f41356f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f41357g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f41358h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f41359i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f41360j;

    /* renamed from: k, reason: collision with root package name */
    private int f41361k;

    /* renamed from: l, reason: collision with root package name */
    private int f41362l;

    /* renamed from: m, reason: collision with root package name */
    private int f41363m;

    /* renamed from: n, reason: collision with root package name */
    private int f41364n;

    /* renamed from: o, reason: collision with root package name */
    private int f41365o;

    /* renamed from: p, reason: collision with root package name */
    private int f41366p;

    /* renamed from: q, reason: collision with root package name */
    private int f41367q;

    /* renamed from: r, reason: collision with root package name */
    private float f41368r;

    /* renamed from: s, reason: collision with root package name */
    private qh.a f41369s;

    /* renamed from: t, reason: collision with root package name */
    private qh.a f41370t;

    /* renamed from: u, reason: collision with root package name */
    private Layout f41371u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f41372v;

    /* renamed from: w, reason: collision with root package name */
    private ClickableSpan f41373w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f41374x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f41375y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SubjectExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            SubjectExpandView subjectExpandView = SubjectExpandView.this;
            subjectExpandView.k(subjectExpandView.f41372v);
            SubjectExpandView.this.f41360j = true;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    public SubjectExpandView(Context context) {
        this(context, null);
    }

    public SubjectExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41354d = "  ";
        this.f41355e = "  ";
        this.f41356f = false;
        this.f41357g = true;
        this.f41358h = true;
        this.f41359i = true;
        this.f41360j = false;
        this.f41361k = 1;
        this.f41362l = -1711276033;
        this.f41363m = -1711276033;
        this.f41364n = 872415231;
        this.f41365o = 872415231;
        this.f41366p = -1;
        this.f41367q = 0;
        this.f41374x = false;
        this.f41375y = false;
        i(context, attributeSet);
    }

    public SubjectExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41354d = "  ";
        this.f41355e = "  ";
        this.f41356f = false;
        this.f41357g = true;
        this.f41358h = true;
        this.f41359i = true;
        this.f41360j = false;
        this.f41361k = 1;
        this.f41362l = -1711276033;
        this.f41363m = -1711276033;
        this.f41364n = 872415231;
        this.f41365o = 872415231;
        this.f41366p = -1;
        this.f41367q = 0;
        this.f41374x = false;
        this.f41375y = false;
        i(context, attributeSet);
    }

    private CharSequence f(int i11) {
        String str;
        int i12;
        TextPaint paint = getPaint();
        if (this.f41372v != null) {
            str = "" + ((Object) this.f41372v);
        } else {
            str = "";
        }
        if (this.f41371u == null) {
            this.f41371u = new StaticLayout(str, paint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.f41371u.getLineCount();
        int i13 = this.f41361k;
        if (lineCount <= i13) {
            CharSequence charSequence = this.f41372v;
            if (charSequence == null) {
                charSequence = " ";
            }
            return l(new SpannableStringBuilder(charSequence));
        }
        int i14 = this.f41367q;
        if (i14 != 0) {
            if (i14 != 1 || !this.f41359i) {
                return l(new SpannableStringBuilder(this.f41372v));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f41372v);
            spannableStringBuilder.append((CharSequence) this.f41355e).append((CharSequence) this.f41353c);
            int length = (spannableStringBuilder.length() - this.f41355e.length()) - this.f41353c.length();
            int length2 = spannableStringBuilder.length();
            i12 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.f41373w, i12, length2, 33);
            spannableStringBuilder.setSpan(this.f41369s, i12, length2, 33);
            return l(spannableStringBuilder);
        }
        int g11 = g(str, paint, this.f41371u.getLineStart(this.f41361k - 1), this.f41371u.getLineEnd(i13 - 1), i11);
        CharSequence charSequence2 = this.f41372v;
        if (charSequence2 != null && charSequence2.length() <= g11) {
            g11 = this.f41372v.length() - 1;
        }
        CharSequence charSequence3 = this.f41372v;
        if (charSequence3 == null || g11 <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder append = new SpannableStringBuilder(charSequence3.length() > 180 ? this.f41372v.subSequence(0, 180) : this.f41372v).append((CharSequence) this.f41351a);
        if (this.f41358h) {
            append.append((CharSequence) this.f41354d);
            append.append((CharSequence) this.f41352b);
            int length3 = (append.length() - this.f41354d.length()) - this.f41352b.length();
            int length4 = append.length();
            i12 = length3 >= 0 ? length3 : 0;
            append.setSpan(this.f41373w, i12, length4, 33);
            append.setSpan(this.f41370t, i12, length4, 33);
        }
        return l(append);
    }

    private int g(String str, TextPaint textPaint, int i11, int i12, int i13) {
        String str2;
        qh.a aVar = this.f41370t;
        String str3 = this.f41351a;
        if (this.f41358h) {
            str2 = this.f41352b + this.f41354d;
        } else {
            str2 = "";
        }
        return textPaint.breakText(str, i11, i12, true, i13 - aVar.e(textPaint, str3, str2), null) + i11;
    }

    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        if (this.f41368r == 0.0f) {
            this.f41368r = getTextSize();
        }
        boolean z10 = getLayoutDirection() == 1;
        this.f41370t = new qh.a(getContext(), R$mipmap.info_player_ic_expand, this.f41362l, this.f41364n, this.f41368r, 5, z10);
        this.f41369s = new qh.a(getContext(), R$mipmap.info_player_ic_collapse, this.f41363m, this.f41365o, this.f41368r, 5, z10);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.f41351a)) {
            this.f41351a = "...";
        }
        if (TextUtils.isEmpty(this.f41352b)) {
            this.f41352b = getResources().getString(R$string.player_more);
        }
        if (TextUtils.isEmpty(this.f41353c)) {
            this.f41353c = getResources().getString(R$string.player_hide);
        }
        if (this.f41354d == null) {
            this.f41354d = "  ";
        }
        if (this.f41355e == null) {
            this.f41355e = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: qh.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectExpandView.this.j(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void i(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            h();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ExpandView_pop_hint_text_size) {
                this.f41368r = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.ExpandView_pop_reverse_Lines) {
                this.f41361k = obtainStyledAttributes.getInteger(index, 1);
            } else if (index == R$styleable.ExpandView_pop_ellipsis) {
                this.f41351a = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_expand_hint) {
                this.f41352b = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint) {
                this.f41353c = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_toggle_enabled) {
                this.f41356f = obtainStyledAttributes.getBoolean(index, this.f41356f);
            } else if (index == R$styleable.ExpandView_pop_show_expand_hint) {
                this.f41358h = obtainStyledAttributes.getBoolean(index, this.f41358h);
            } else if (index == R$styleable.ExpandView_pop_show_shrink_hint) {
                this.f41359i = obtainStyledAttributes.getBoolean(index, this.f41359i);
            } else if (index == R$styleable.ExpandView_pop_expand_hint_color) {
                this.f41362l = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint_color) {
                this.f41363m = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_expand_bg_Color) {
                this.f41364n = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_shrink_bg_color) {
                this.f41365o = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_Init_state) {
                this.f41367q = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_expand_gap) {
                this.f41354d = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_collapse_gap) {
                this.f41355e = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_hash_tag_color) {
                this.f41366p = obtainStyledAttributes.getInteger(index, this.f41366p);
            }
        }
        obtainStyledAttributes.recycle();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        m();
    }

    private CharSequence l(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void m() {
        if (getText().toString().contains(this.f41352b) || getText().toString().contains(this.f41353c) || this.f41375y) {
            int i11 = this.f41367q;
            if (i11 == 0) {
                this.f41367q = 1;
            } else if (i11 == 1) {
                this.f41367q = 0;
            }
            k(this.f41372v);
        }
    }

    public int getExpandState() {
        return this.f41367q;
    }

    public boolean isOutLines() {
        Layout layout = this.f41371u;
        return layout != null && layout.getLineCount() > this.f41361k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.f41367q = 0;
        k(this.f41372v);
    }

    public void setCollapseEnable(boolean z10) {
        this.f41357g = z10;
    }

    public void setExpandListener(b bVar) {
    }

    public void setHasStarring(boolean z10) {
        this.f41374x = z10;
    }

    public void setShrink(boolean z10) {
        this.f41375y = z10;
        if (z10) {
            this.f41367q = 1;
            m();
            this.f41375y = false;
        }
    }

    /* renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void k(final CharSequence charSequence) {
        if (!this.f41357g) {
            super.setText(charSequence);
            return;
        }
        if (!TextUtils.equals(charSequence, this.f41372v)) {
            this.f41371u = null;
        }
        this.f41372v = charSequence;
        int layoutWidth = getLayoutWidth();
        if (this.f41374x) {
            if (this.f41367q == 1) {
                super.setText(charSequence);
                return;
            }
            if (this.f41372v != null) {
                charSequence = f(layoutWidth);
            }
            super.setText(charSequence);
            return;
        }
        if (layoutWidth > 0) {
            if (this.f41372v != null) {
                charSequence = f(layoutWidth);
            }
            super.setText(charSequence);
        } else if (this.f41360j) {
            postDelayed(new Runnable() { // from class: qh.f
                @Override // java.lang.Runnable
                public final void run() {
                    SubjectExpandView.this.k(charSequence);
                }
            }, 100L);
        }
    }
}
