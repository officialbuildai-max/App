package com.transsion.ad.monopoly.manager;

import android.app.Application;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import ti.f;

/* loaded from: classes5.dex */
public final class AdPlansAssetsManager extends c {

    /* renamed from: b, reason: collision with root package name */
    public static final AdPlansAssetsManager f42203b = new AdPlansAssetsManager();

    private AdPlansAssetsManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MbAdPlansDto e(MbAdPlansDto mbAdPlansDto) {
        List<AdPlans> adPlans;
        MbAdPlansBean data = mbAdPlansDto.getData();
        if (data != null && (adPlans = data.getAdPlans()) != null) {
            for (AdPlans adPlans2 : adPlans) {
                AdPlansAssetsManager adPlansAssetsManager = f42203b;
                String advertiserAvatar = adPlans2.getAdvertiserAvatar();
                if (advertiserAvatar == null) {
                    advertiserAvatar = "";
                }
                String g11 = adPlansAssetsManager.g(advertiserAvatar);
                if (!TextUtils.isEmpty(g11)) {
                    adPlans2.setAdvertiserAvatarPath(g11);
                }
                List<AdMaterialList> adMaterialList = adPlans2.getAdMaterialList();
                if (adMaterialList != null) {
                    for (AdMaterialList adMaterialList2 : adMaterialList) {
                        MbAdVideo video = adMaterialList2.getVideo();
                        if (video != null) {
                            AdPlansAssetsManager adPlansAssetsManager2 = f42203b;
                            String url = video.getUrl();
                            if (url == null) {
                                url = "";
                            }
                            String g12 = adPlansAssetsManager2.g(url);
                            if (!TextUtils.isEmpty(g12)) {
                                video.setPath(g12);
                                adMaterialList2.setDownloadMaterialSuccess(true);
                            }
                        }
                        MbAdImage image = adMaterialList2.getImage();
                        if (image != null) {
                            AdPlansAssetsManager adPlansAssetsManager3 = f42203b;
                            String url2 = image.getUrl();
                            if (url2 == null) {
                                url2 = "";
                            }
                            String g13 = adPlansAssetsManager3.g(url2);
                            if (!TextUtils.isEmpty(g13)) {
                                image.setPath(g13);
                                adMaterialList2.setDownloadMaterialSuccess(true);
                            }
                        }
                    }
                }
            }
        }
        return mbAdPlansDto;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(MbAdPlansDto mbAdPlansDto, Continuation continuation) {
        MbAdPlansBean data = mbAdPlansDto.getData();
        if (data != null) {
            ArrayList arrayList = new ArrayList();
            List<AdPlans> adPlans = data.getAdPlans();
            if (adPlans != null) {
                Iterator<T> it = adPlans.iterator();
                while (it.hasNext()) {
                    MbAdDbPlans a11 = AdPlansTransform.f42222a.a((AdPlans) it.next());
                    a11.setVersion(data.getVersion());
                    arrayList.add(a11);
                }
            }
            Object q11 = AdPlansStorageManager.f42207a.q(arrayList, continuation);
            if (q11 == IntrinsicsKt.f()) {
                return q11;
            }
        }
        return Unit.f67184a;
    }

    private final String g(String str) {
        File file = new File(com.transsion.ad.a.f41834a.b(), System.currentTimeMillis() + ".mineType");
        f fVar = f.f76378a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        if (fVar.a(a11, str, file)) {
            return file.getAbsolutePath();
        }
        return null;
    }

    @Override // com.transsion.ad.monopoly.manager.c
    public Object b(Continuation continuation) {
        Object g11 = i.g(y0.b(), new AdPlansAssetsManager$innerCopy$2(null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }
}
