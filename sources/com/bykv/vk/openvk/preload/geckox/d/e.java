package com.bykv.vk.openvk.preload.geckox.d;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class e extends com.bykv.vk.openvk.preload.b.d<String, Map<String, List<Pair<String, Long>>>> {

    /* renamed from: d, reason: collision with root package name */
    private File f20761d;

    /* renamed from: e, reason: collision with root package name */
    private List<String> f20762e;

    @Override // com.bykv.vk.openvk.preload.b.d
    public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.b.b<Map<String, List<Pair<String, Long>>>> bVar, String str) throws Throwable {
        Long a11;
        GeckoLogger.d("gecko-debug-tag", "get local channel version:", str);
        HashMap hashMap = new HashMap();
        for (String str2 : this.f20762e) {
            File file = new File(this.f20761d, str2);
            String[] list = file.list();
            ArrayList arrayList = new ArrayList();
            if (list != null && list.length > 0) {
                for (String str3 : list) {
                    File file2 = new File(file, str3);
                    if (file2.isDirectory() && (a11 = com.bykv.vk.openvk.preload.geckox.utils.g.a(file2)) != null) {
                        arrayList.add(new Pair<>(str3, a11));
                    }
                }
            }
            hashMap.put(str2, arrayList);
        }
        return bVar.a((com.bykv.vk.openvk.preload.b.b<Map<String, List<Pair<String, Long>>>>) hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final void a(Object... objArr) {
        super.a(objArr);
        this.f20761d = (File) objArr[0];
        this.f20762e = (List) objArr[1];
    }
}
