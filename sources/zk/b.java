package zk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.i;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private yk.b f79552a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b bVar, View view) {
        bVar.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        yk.b c11 = yk.b.c(getLayoutInflater());
        this.f79552a = c11;
        yk.b bVar = null;
        if (c11 == null) {
            Intrinsics.z("viewBinding");
            c11 = null;
        }
        setContentView(c11.getRoot());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(null);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.gravity = 17;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.width = y.e() - i.e(70.0f);
            }
        }
        float e11 = i.e(8.0f);
        yk.b bVar2 = this.f79552a;
        if (bVar2 == null) {
            Intrinsics.z("viewBinding");
            bVar2 = null;
        }
        LinearLayout root = bVar2.getRoot();
        Intrinsics.g(root, "getRoot(...)");
        al.a.a(root, e11);
        yk.b bVar3 = this.f79552a;
        if (bVar3 == null) {
            Intrinsics.z("viewBinding");
            bVar3 = null;
        }
        AppCompatTextView btnOk = bVar3.f79152b;
        Intrinsics.g(btnOk, "btnOk");
        al.a.a(btnOk, e11);
        yk.b bVar4 = this.f79552a;
        if (bVar4 == null) {
            Intrinsics.z("viewBinding");
        } else {
            bVar = bVar4;
        }
        bVar.f79152b.setOnClickListener(new View.OnClickListener() { // from class: zk.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.b(b.this, view);
            }
        });
    }
}
