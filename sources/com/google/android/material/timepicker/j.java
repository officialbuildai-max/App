package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes4.dex */
class j implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    private final ChipTextInputComboView f30186a;

    /* renamed from: b, reason: collision with root package name */
    private final ChipTextInputComboView f30187b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeModel f30188c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f30189d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f30186a = chipTextInputComboView;
        this.f30187b = chipTextInputComboView2;
        this.f30188c = timeModel;
    }

    private void b(EditText editText) {
        if (editText.getSelectionStart() == 0 && editText.length() == 2) {
            editText.getText().clear();
        }
    }

    private void c(int i11) {
        this.f30187b.setChecked(i11 == 12);
        this.f30186a.setChecked(i11 == 10);
        this.f30188c.f30153d = i11;
    }

    private boolean d(int i11, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i11 >= 7 && i11 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            c(12);
            return true;
        }
        b(editText);
        return false;
    }

    private boolean e(int i11, KeyEvent keyEvent, EditText editText) {
        if (i11 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            c(10);
            return true;
        }
        b(editText);
        return false;
    }

    public void a() {
        TextInputLayout e11 = this.f30186a.e();
        TextInputLayout e12 = this.f30187b.e();
        EditText editText = e11.getEditText();
        EditText editText2 = e12.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        boolean z10 = i11 == 5;
        if (z10) {
            c(12);
        }
        return z10;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i11, KeyEvent keyEvent) {
        if (this.f30189d) {
            return false;
        }
        this.f30189d = true;
        EditText editText = (EditText) view;
        boolean e11 = this.f30188c.f30153d == 12 ? e(i11, keyEvent, editText) : d(i11, keyEvent, editText);
        this.f30189d = false;
        return e11;
    }
}
