package com.transsion.rewardscenter.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.ui.RewardsCenterFragment;
import com.transsion.rewardscenterapi.SkuPoint;
import com.transsion.rewardscenterapi.TopUpType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class f {
    public static final void c(final wp.a config, final TopUpType topUpType, final SkuPoint skuPoint) {
        Context context;
        Intrinsics.h(config, "config");
        Intrinsics.h(topUpType, "topUpType");
        RewardsCenterFragment rewardsCenterFragment = (RewardsCenterFragment) config.a().get();
        if (rewardsCenterFragment == null || (context = rewardsCenterFragment.getContext()) == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_payment_required, (ViewGroup) null, false);
        final AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        ((Button) inflate.findViewById(R$id.btn_complete_now)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.utils.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.d(create, config, topUpType, skuPoint, view);
            }
        });
        ((ImageButton) inflate.findViewById(R$id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.utils.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.e(create, view);
            }
        });
        create.show();
        Window window2 = create.getWindow();
        if (window2 != null) {
            window2.setLayout((int) (context.getResources().getDisplayMetrics().widthPixels * 0.8d), -2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AlertDialog alertDialog, wp.a aVar, TopUpType topUpType, SkuPoint skuPoint, View view) {
        alertDialog.dismiss();
        RewardsCenterFragment rewardsCenterFragment = (RewardsCenterFragment) aVar.a().get();
        if (rewardsCenterFragment != null) {
            rewardsCenterFragment.J1(topUpType, skuPoint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
    }
}
