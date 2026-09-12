package fw;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.transsion.usercenter.R$id;

/* loaded from: classes7.dex */
public final class v implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f63069a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f63070b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f63071c;

    /* renamed from: d, reason: collision with root package name */
    public final RadioButton f63072d;

    /* renamed from: e, reason: collision with root package name */
    public final RadioButton f63073e;

    /* renamed from: f, reason: collision with root package name */
    public final RadioGroup f63074f;

    private v(FrameLayout frameLayout, Button button, Button button2, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup) {
        this.f63069a = frameLayout;
        this.f63070b = button;
        this.f63071c = button2;
        this.f63072d = radioButton;
        this.f63073e = radioButton2;
        this.f63074f = radioGroup;
    }

    public static v a(View view) {
        int i11 = R$id.btnCancel;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnOk;
            Button button2 = (Button) g4.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.radioButtonFpsClose;
                RadioButton radioButton = (RadioButton) g4.b.a(view, i11);
                if (radioButton != null) {
                    i11 = R$id.radioButtonFpsOpen;
                    RadioButton radioButton2 = (RadioButton) g4.b.a(view, i11);
                    if (radioButton2 != null) {
                        i11 = R$id.radioGroup;
                        RadioGroup radioGroup = (RadioGroup) g4.b.a(view, i11);
                        if (radioGroup != null) {
                            return new v((FrameLayout) view, button, button2, radioButton, radioButton2, radioGroup);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f63069a;
    }
}
