package com.mbridge.msdk.dycreator.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.engine.b;
import com.mbridge.msdk.dycreator.error.a;
import com.mbridge.msdk.dycreator.utils.f;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewmodel.MBCommonViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBRewardViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DynamicViewCreator {

    /* renamed from: a, reason: collision with root package name */
    private static volatile DynamicViewCreator f35010a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f35011b = -201;

    /* renamed from: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35012a;

        static {
            int[] iArr = new int[DyAdType.values().length];
            f35012a = iArr;
            try {
                iArr[DyAdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35012a[DyAdType.REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private DynamicViewCreator() {
        b.a().a(c.m().d());
    }

    private View a(Context context, DyOption dyOption) {
        List<String> fileDirs;
        ViewGroup viewGroup = null;
        if (dyOption == null || (fileDirs = dyOption.getFileDirs()) == null) {
            return null;
        }
        for (int i11 = 0; i11 < fileDirs.size(); i11++) {
            try {
                if (!TextUtils.isEmpty(fileDirs.get(i11))) {
                    if (i11 == 0) {
                        viewGroup = (ViewGroup) f.a(context).a(fileDirs.get(i11));
                    } else {
                        a(context, viewGroup, fileDirs.get(i11));
                    }
                }
            } catch (Exception e11) {
                o0.b("DynamicViewCreator", e11.getMessage());
            }
        }
        return viewGroup;
    }

    private void a(Context context, ViewGroup viewGroup, View view, JSONObject jSONObject) {
        if (context == null || viewGroup == null || view == null || jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("parent_id");
            if (!TextUtils.isEmpty(optString)) {
                viewGroup = (ViewGroup) f.a(context).a(viewGroup, optString);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            String optString2 = jSONObject.optString("below", "");
            if (!TextUtils.isEmpty(optString2)) {
                layoutParams.addRule(3, optString2.hashCode());
            }
            String optString3 = jSONObject.optString("left_of", "");
            if (!TextUtils.isEmpty(optString3)) {
                layoutParams.addRule(0, optString3.hashCode());
            }
            String optString4 = jSONObject.optString("right_of", "");
            if (!TextUtils.isEmpty(optString4)) {
                layoutParams.addRule(1, optString4.hashCode());
            }
            int optInt = jSONObject.optInt("index", -2);
            int optInt2 = jSONObject.optInt("visibility", -1);
            if (optInt2 != -1) {
                view.setVisibility(optInt2);
            }
            if (optInt != -2) {
                viewGroup.addView(view, optInt, layoutParams);
            } else {
                viewGroup.addView(view, layoutParams);
            }
        } catch (Exception e11) {
            o0.b("DynamicViewCreator", e11.getMessage());
        }
    }

    private void a(Context context, ViewGroup viewGroup, String str) {
        if (context == null || viewGroup == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("folder_dir");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(jSONObject.optString("ext_template"));
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                if (jSONObject2 != null) {
                    View a11 = f.a(context).a(string + File.separator + jSONObject2.optString("name"));
                    if (a11 != null) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(TtmlNode.TAG_LAYOUT);
                        if (jSONObject3 != null) {
                            a(context, viewGroup, a11, jSONObject3);
                        } else {
                            viewGroup.addView(a11, 3);
                        }
                    }
                }
            }
        } catch (Exception e11) {
            o0.b("DynamicViewCreator", e11.getMessage());
        }
    }

    private boolean a(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener, String... strArr) {
        boolean z10 = true;
        if (dyOption != null) {
            if (dyOption.getCampaignEx() == null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.NOT_FOUND_CAMPAIGN));
                z10 = false;
            }
            if (dyOption.getFile() == null && dyOption.getFileDirs() != null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.BIND_DATA_FILE_OR_DIR));
                z10 = false;
            }
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (TextUtils.isEmpty(str)) {
                        z10 = false;
                    }
                }
            }
        }
        return z10;
    }

    public static DynamicViewCreator getInstance() {
        if (f35010a == null) {
            synchronized (DynamicViewCreator.class) {
                try {
                    if (f35010a == null) {
                        f35010a = new DynamicViewCreator();
                    }
                } finally {
                }
            }
        }
        return f35010a;
    }

    public View createDynamicView(DyOption dyOption) {
        Context d11;
        if (dyOption == null || (d11 = c.m().d()) == null) {
            return null;
        }
        return a(d11, dyOption);
    }

    public void createDynamicView(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener) {
        BaseViewModel mBSplashViewVModel;
        BaseViewModel baseViewModel;
        if (dyOption == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.NOT_FOUND_DYNAMIC_OPTION));
            return;
        }
        if (dynamicViewBackListener == null) {
            return;
        }
        Context d11 = c.m().d();
        if (d11 == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.NOT_FOUND_CONTEXT));
            return;
        }
        if (a(dyOption, dynamicViewBackListener, new String[0])) {
            try {
                View a11 = a(d11, dyOption);
                if (a11 == null) {
                    dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.FILE_CREATE_VIEW_FILE));
                    return;
                }
                int i11 = AnonymousClass1.f35012a[dyOption.getDyAdType().ordinal()];
                if (i11 == 1) {
                    mBSplashViewVModel = new MBSplashViewVModel(dyOption);
                } else {
                    if (i11 != 2) {
                        baseViewModel = new MBCommonViewVModel();
                        baseViewModel.setDynamicViewBackListener(dynamicViewBackListener);
                        com.mbridge.msdk.dycreator.binding.b.a().a(baseViewModel);
                        baseViewModel.setModelDataAndBind();
                        dynamicViewBackListener.viewCreatedSuccess(a11);
                    }
                    mBSplashViewVModel = new MBRewardViewVModel(dyOption);
                }
                baseViewModel = mBSplashViewVModel;
                baseViewModel.setDynamicViewBackListener(dynamicViewBackListener);
                com.mbridge.msdk.dycreator.binding.b.a().a(baseViewModel);
                baseViewModel.setModelDataAndBind();
                dynamicViewBackListener.viewCreatedSuccess(a11);
            } catch (Exception e11) {
                o0.b("DynamicViewCreator", e11.getMessage());
                dynamicViewBackListener.viewCreateFail(new a(f35011b, e11.getMessage()));
            }
        }
    }
}
