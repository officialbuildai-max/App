package com.cloud.tmc.miniapp.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class Oooo000 extends OooO0O0.OooO00o<Oooo000> {
    public final Lazy OooO00o;
    public final Lazy OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;

    /* loaded from: classes3.dex */
    public static final class OooO00o extends Lambda implements Function0<TextView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) Oooo000.this.findViewById(R.id.btn_common_dialog_left);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function0<TextView> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) Oooo000.this.findViewById(R.id.btn_common_dialog_right);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) Oooo000.this.findViewById(R.id.txt_common_dialog_describe);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) Oooo000.this.findViewById(R.id.txt_common_dialog_title);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oooo000(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = LazyKt.b(new OooO0o());
        this.OooO0O0 = LazyKt.b(new OooO0OO());
        this.OooO0OO = LazyKt.b(new OooO00o());
        this.OooO0Oo = LazyKt.b(new OooO0O0());
        setContentView(R.layout.layout_fw_update_tips);
        setCanceledOnTouchOutside(false);
        setAnimStyle(-1);
        TextView OooO0Oo = OooO0Oo();
        if (OooO0Oo != null) {
            OooO0Oo.setText(getString(R.string.mini_dialog_download_error_title));
        }
        TextView OooO0OO2 = OooO0OO();
        if (OooO0OO2 != null) {
            OooO0OO2.setText(getString(R.string.mini_dialog_download_error_content));
        }
        TextView OooO00o2 = OooO00o();
        if (OooO00o2 != null) {
            OooO00o2.setText(getString(R.string.mini_text_cancel));
        }
        TextView OooO0O02 = OooO0O0();
        if (OooO0O02 != null) {
            OooO0O02.setText(getString(R.string.mini_dialog_download_error_retry_btn));
        }
        setOnClickListener(OooO00o(), OooO0O0());
    }

    public final TextView OooO00o() {
        return (TextView) this.OooO0OO.getValue();
    }

    public final TextView OooO0O0() {
        return (TextView) this.OooO0Oo.getValue();
    }

    public final TextView OooO0OO() {
        return (TextView) this.OooO0O0.getValue();
    }

    public final TextView OooO0Oo() {
        return (TextView) this.OooO00o.getValue();
    }

    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooO00o, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.h(view, "view");
        if (Intrinsics.c(view, OooO00o())) {
            Context context = getContext();
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity != null) {
                miniAppActivity.killActivity();
                return;
            }
            return;
        }
        if (Intrinsics.c(view, OooO0O0())) {
            Context context2 = getContext();
            MiniAppActivity miniAppActivity2 = context2 instanceof MiniAppActivity ? (MiniAppActivity) context2 : null;
            if (miniAppActivity2 != null) {
                MiniAppActivity.reload$default(miniAppActivity2, false, null, 3, null);
            }
            dismiss();
        }
    }
}
