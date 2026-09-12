package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R$string;
import com.google.android.material.internal.a0;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class e extends a0 {

    /* renamed from: a, reason: collision with root package name */
    private final TextInputLayout f28930a;

    /* renamed from: b, reason: collision with root package name */
    private final String f28931b;

    /* renamed from: c, reason: collision with root package name */
    private final DateFormat f28932c;

    /* renamed from: d, reason: collision with root package name */
    private final CalendarConstraints f28933d;

    /* renamed from: e, reason: collision with root package name */
    private final String f28934e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f28935f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f28936g;

    /* renamed from: h, reason: collision with root package name */
    private int f28937h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f28931b = str;
        this.f28932c = dateFormat;
        this.f28930a = textInputLayout;
        this.f28933d = calendarConstraints;
        this.f28934e = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f28935f = new Runnable() { // from class: com.google.android.material.datepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.e(str);
            }
        };
    }

    private Runnable c(final long j11) {
        return new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.d(j11);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(long j11) {
        this.f28930a.setError(String.format(this.f28934e, i(j.c(j11))));
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.f28930a;
        DateFormat dateFormat = this.f28932c;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), i(str)) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), i(dateFormat.format(new Date(x.q().getTimeInMillis())))));
        f();
    }

    private String i(String str) {
        return str.replace(' ', (char) 160);
    }

    @Override // com.google.android.material.internal.a0, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.f28931b.length() && editable.length() >= this.f28937h) {
            char charAt = this.f28931b.charAt(editable.length());
            if (Character.isLetterOrDigit(charAt)) {
                return;
            }
            editable.append(charAt);
        }
    }

    @Override // com.google.android.material.internal.a0, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.f28937h = charSequence.length();
    }

    abstract void f();

    abstract void g(Long l11);

    public void h(View view, Runnable runnable) {
        view.post(runnable);
    }

    @Override // com.google.android.material.internal.a0, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.f28930a.removeCallbacks(this.f28935f);
        this.f28930a.removeCallbacks(this.f28936g);
        this.f28930a.setError(null);
        g(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.f28931b.length()) {
            return;
        }
        try {
            Date parse = this.f28932c.parse(charSequence.toString());
            this.f28930a.setError(null);
            long time = parse.getTime();
            if (this.f28933d.getDateValidator().isValid(time) && this.f28933d.isWithinBounds(time)) {
                g(Long.valueOf(parse.getTime()));
                return;
            }
            Runnable c11 = c(time);
            this.f28936g = c11;
            h(this.f28930a, c11);
        } catch (ParseException unused) {
            h(this.f28930a, this.f28935f);
        }
    }
}
