package nw;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.view.Lifecycle;
import androidx.view.d0;
import androidx.view.t;
import androidx.view.u;
import com.blankj.utilcode.util.h;
import com.google.android.material.bottomsheet.c;
import com.tn.lib.widget.R$color;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.R$style;

/* loaded from: classes7.dex */
public class b implements View.OnClickListener, t {

    /* renamed from: a, reason: collision with root package name */
    private Activity f70707a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f70708b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f70709c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f70710d;

    /* renamed from: e, reason: collision with root package name */
    private a f70711e;

    /* renamed from: f, reason: collision with root package name */
    private c f70712f;

    /* renamed from: g, reason: collision with root package name */
    private String f70713g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f70714h;

    /* loaded from: classes6.dex */
    public interface a {
        void onDialogSelect(int i11, String str);
    }

    public b(Activity activity, a aVar, String str) {
        this.f70707a = activity;
        this.f70711e = aVar;
        this.f70713g = str;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.f70707a).inflate(R$layout.dialog_edit_gender, (ViewGroup) null);
        this.f70708b = (TextView) inflate.findViewById(R$id.tv_first);
        this.f70709c = (TextView) inflate.findViewById(R$id.tv_second);
        this.f70710d = (TextView) inflate.findViewById(R$id.tv_third);
        this.f70708b.setOnClickListener(this);
        this.f70709c.setOnClickListener(this);
        this.f70710d.setOnClickListener(this);
        c cVar = new c(this.f70707a, R$style.BottomDialog1);
        this.f70712f = cVar;
        cVar.getWindow().setWindowAnimations(R$style.bottom_dialog_animation);
        this.f70712f.setContentView(inflate);
    }

    public void b() {
        if (TextUtils.equals(this.f70713g, this.f70707a.getString(R$string.profile_female))) {
            this.f70708b.setTextColor(h.a(R$color.white));
            this.f70709c.setTextColor(h.a(R$color.text_03));
            this.f70710d.setTextColor(h.a(R$color.text_03));
        } else if (TextUtils.equals(this.f70713g, this.f70707a.getString(R$string.profile_male))) {
            this.f70709c.setTextColor(h.a(R$color.white));
            this.f70708b.setTextColor(h.a(R$color.text_03));
            this.f70710d.setTextColor(h.a(R$color.text_03));
        } else {
            this.f70710d.setTextColor(h.a(R$color.white));
            this.f70708b.setTextColor(h.a(R$color.text_03));
            this.f70709c.setTextColor(h.a(R$color.text_03));
        }
        this.f70708b.setText(R$string.profile_female);
        this.f70709c.setText(R$string.profile_male);
        this.f70710d.setText(R$string.profile_gender_other);
        this.f70712f.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.tv_first) {
            a aVar = this.f70711e;
            if (aVar != null) {
                aVar.onDialogSelect(0, this.f70708b.getText().toString());
                this.f70712f.dismiss();
                return;
            }
            return;
        }
        if (id2 != R$id.tv_second) {
            if (id2 == R$id.tv_third) {
                this.f70711e.onDialogSelect(2, this.f70710d.getText().toString());
                this.f70712f.dismiss();
                return;
            }
            return;
        }
        a aVar2 = this.f70711e;
        if (aVar2 != null) {
            aVar2.onDialogSelect(1, this.f70709c.getText().toString());
            this.f70712f.dismiss();
        }
    }

    @d0(Lifecycle.Event.ON_ANY)
    public void onLifecycleChanged(u uVar, Lifecycle.Event event) {
    }

    @d0(Lifecycle.Event.ON_PAUSE)
    public void onPause(u uVar) {
        this.f70714h = false;
    }

    @d0(Lifecycle.Event.ON_RESUME)
    public void onResume(u uVar) {
        this.f70714h = true;
    }
}
