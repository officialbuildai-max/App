package com.bykv.vk.openvk.preload.geckox.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.model.ComponentModel;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import java.io.File;
import java.io.FileFilter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class c extends com.bykv.vk.openvk.preload.b.d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {

    /* renamed from: d, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.b f20752d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Map<String, Object>> f20753e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, List<CheckRequestBodyModel.TargetChannel>> f20754f;

    /* renamed from: g, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.e.a f20755g;

    /* renamed from: h, reason: collision with root package name */
    private String f20756h;

    /* renamed from: i, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.buffer.a.a f20757i = new com.bykv.vk.openvk.preload.geckox.buffer.a.a();

    /* loaded from: classes2.dex */
    public static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends RuntimeException {
        b(String str, Throwable th2) {
            super(str, th2);
        }
    }

    /* renamed from: com.bykv.vk.openvk.preload.geckox.d.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0201c extends RuntimeException {
        C0201c(String str, Throwable th2) {
            super(str, th2);
        }
    }

    private static long a(List<Pair<String, Long>> list, String str) {
        for (Pair<String, Long> pair : list) {
            if (((String) pair.first).equals(str)) {
                return ((Long) pair.second).longValue();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bykv.vk.openvk.preload.b.d
    public Object a(com.bykv.vk.openvk.preload.b.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Throwable {
        List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> list;
        char c11 = 2;
        int i11 = 0;
        char c12 = 1;
        GeckoLogger.d("gecko-debug-tag", "start get server channel version[v3]... local channel version:", map);
        Map<String, List<UpdatePackage>> a11 = a(map);
        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f20752d, this.f20757i);
        Iterator<Map.Entry<String, List<UpdatePackage>>> it = a11.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<UpdatePackage> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                UpdatePackage next = it2.next();
                long localVersion = next.getLocalVersion();
                long version = next.getVersion();
                if (version < localVersion) {
                    String channel = next.getChannel();
                    Long valueOf = Long.valueOf(localVersion);
                    Long valueOf2 = Long.valueOf(version);
                    Object[] objArr = new Object[5];
                    objArr[i11] = channel;
                    objArr[c12] = "rollback：";
                    objArr[c11] = valueOf;
                    objArr[3] = "->";
                    objArr[4] = valueOf2;
                    GeckoLogger.d("gecko-debug-tag", objArr);
                    File[] listFiles = new File(this.f20752d.n(), next.getAccessKey() + File.separator + next.getChannel()).listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return file.isDirectory();
                        }
                    });
                    if (listFiles == null || listFiles.length == 0) {
                        c11 = 2;
                        c12 = 1;
                        i11 = 0;
                    } else {
                        int length = listFiles.length;
                        int i12 = i11;
                        while (i12 < length) {
                            File file = listFiles[i12];
                            try {
                                long parseLong = Long.parseLong(file.getName());
                                if (parseLong > version) {
                                    final File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                                    file.renameTo(file2);
                                    com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.bykv.vk.openvk.preload.geckox.utils.b.a(file2);
                                        }
                                    });
                                } else if (parseLong == version) {
                                    it2.remove();
                                }
                            } catch (Exception unused) {
                            }
                            i12++;
                            c12 = 1;
                            c11 = 2;
                            i11 = 0;
                        }
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, List<UpdatePackage>>> it3 = a11.entrySet().iterator();
        while (it3.hasNext()) {
            arrayList.addAll(it3.next().getValue());
        }
        Object obj = null;
        try {
            list = c(arrayList);
            try {
                obj = bVar.a((com.bykv.vk.openvk.preload.b.b<List<UpdatePackage>>) arrayList);
                b(list);
                GeckoLogger.d("gecko-debug-tag", "all channel update finished");
            } catch (Throwable th2) {
                th = th2;
                try {
                    GeckoLogger.e("gecko-debug-tag", "filterChannel:", th);
                    b(list);
                    GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                    a(arrayList);
                    return obj;
                } catch (Throwable th3) {
                    b(list);
                    GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            list = null;
        }
        a(arrayList);
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<String, List<UpdatePackage>> a(Map<String, List<Pair<String, Long>>> map) throws Exception {
        String b11 = b(map);
        String str = "https://" + this.f20752d.j() + "/gecko/server/v3/package";
        try {
            this.f20757i.f20719f = com.bykv.vk.openvk.preload.geckox.utils.e.a(this.f20752d.a());
            Response doPost = this.f20752d.i().doPost(str, b11);
            com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar = this.f20757i;
            aVar.f20720g = doPost.code;
            aVar.f20717d = doPost.msg;
            Map<String, String> map2 = doPost.headers;
            String str2 = "";
            if (map2 != null && !map2.isEmpty()) {
                String str3 = map2.get("x-tt-logid");
                if (TextUtils.isEmpty(str3)) {
                    str3 = map2.get("X-Tt-Logid");
                    if (TextUtils.isEmpty(str3)) {
                        String str4 = map2.get("X-TT-LOGID");
                        if (!TextUtils.isEmpty(str4)) {
                            str2 = str4;
                        }
                    }
                }
                str2 = str3;
            }
            aVar.f20718e = str2;
            if (doPost.code != 200) {
                throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str);
            }
            String str5 = doPost.body;
            GeckoLogger.d("gecko-debug-tag", "response:", str5);
            try {
                com.bykv.vk.openvk.preload.geckox.model.Response response = (com.bykv.vk.openvk.preload.geckox.model.Response) (str5 == null ? null : com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(new StringReader(str5), new com.bykv.vk.openvk.preload.a.c.a<com.bykv.vk.openvk.preload.geckox.model.Response<ComponentModel>>() { // from class: com.bykv.vk.openvk.preload.geckox.d.c.3
                }.b()));
                int i11 = response.status;
                if (i11 != 0) {
                    if (i11 == 2000) {
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.f20752d);
                        return new HashMap();
                    }
                    String str6 = "check update error，unknow status code，response.status：" + response.status;
                    com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar2 = this.f20757i;
                    aVar2.f20717d = str6;
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f20752d, aVar2);
                    throw new a(str6);
                }
                if (response.data == 0) {
                    com.bykv.vk.openvk.preload.geckox.buffer.a.a aVar3 = this.f20757i;
                    aVar3.f20717d = "check update error：response.data==null";
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f20752d, aVar3);
                    throw new a("check update error：response.data==null");
                }
                com.bykv.vk.openvk.preload.geckox.a.a.a(this.f20752d.a(), ((ComponentModel) response.data).getUniversalStrategies(), this.f20752d.n(), this.f20755g);
                Map<String, List<UpdatePackage>> packages = ((ComponentModel) response.data).getPackages();
                if (packages == null || packages.isEmpty()) {
                    com.bykv.vk.openvk.preload.geckox.a.a.a(this.f20752d);
                    return new HashMap();
                }
                for (String str7 : this.f20752d.e()) {
                    List<UpdatePackage> list = packages.get(str7);
                    if (list != null && !list.isEmpty()) {
                        for (UpdatePackage updatePackage : list) {
                            updatePackage.setAccessKey(str7);
                            updatePackage.setLocalVersion(a(map.get(str7), updatePackage.getChannel()));
                        }
                    }
                }
                return packages;
            } catch (Throwable th2) {
                this.f20757i.f20717d = "json parse failed：" + th2.getMessage();
                com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f20752d, this.f20757i);
                throw new b("json parse failed：" + str5 + " caused by:" + th2.getMessage(), th2);
            }
        } catch (Exception e11) {
            com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.f20752d, this.f20757i);
            throw new C0201c("request failed：url:" + str + ", caused by:" + e11.getMessage(), e11);
        }
    }

    private void a(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return;
        }
        for (UpdatePackage updatePackage : list) {
            com.bykv.vk.openvk.preload.geckox.a.c.a(new File(new File(this.f20752d.n(), updatePackage.getAccessKey()), updatePackage.getChannel()).getAbsolutePath());
        }
    }

    private String b(Map<String, List<Pair<String, Long>>> map) {
        List<CheckRequestBodyModel.TargetChannel> list;
        CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
        Context a11 = this.f20752d.a();
        checkRequestBodyModel.setCommon(new Common(this.f20752d.k(), this.f20752d.o(), this.f20752d.r(), com.bykv.vk.openvk.preload.geckox.utils.a.b(a11), com.bykv.vk.openvk.preload.geckox.utils.e.a(a11), this.f20752d.l(), this.f20752d.m()));
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<Pair<String, Long>>> entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Pair<String, Long> pair : entry.getValue()) {
                CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                localChannel.localVersion = (Long) pair.second;
                hashMap2.put(pair.first, localChannel);
            }
            hashMap.put(entry.getKey(), hashMap2);
        }
        try {
            com.bykv.vk.openvk.preload.a.d b11 = com.bykv.vk.openvk.preload.geckox.c.b.a().b();
            this.f20757i.f20714a = b11.a(hashMap);
            checkRequestBodyModel.setLocal(hashMap);
            HashMap hashMap3 = new HashMap();
            for (String str : this.f20752d.e()) {
                CheckRequestBodyModel.Group group = new CheckRequestBodyModel.Group();
                group.groupName = this.f20756h;
                Map<String, List<CheckRequestBodyModel.TargetChannel>> map2 = this.f20754f;
                if (map2 != null && !map2.isEmpty() && (list = this.f20754f.get(str)) != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    group.targetChannels = arrayList;
                    arrayList.addAll(list);
                }
                hashMap3.put(str, group);
            }
            this.f20757i.f20715b = b11.a(hashMap3);
            checkRequestBodyModel.setDeployments(hashMap3);
            Map<String, Map<String, Object>> map3 = this.f20753e;
            if (map3 != null) {
                this.f20757i.f20716c = b11.a(map3);
                checkRequestBodyModel.setCustom(this.f20753e);
            }
            return b11.a(checkRequestBodyModel);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b(List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> list) {
        if (list == null) {
            return;
        }
        Iterator<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> it = list.iterator();
        while (it.hasNext()) {
            try {
                ((com.bykv.vk.openvk.preload.geckox.g.a) it.next().second).a();
            } catch (Exception e11) {
                GeckoLogger.e("gecko-debug-tag", "releaseLock:", e11);
            }
        }
    }

    private List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> c(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UpdatePackage updatePackage : list) {
            try {
                File file = new File(new File(this.f20752d.n(), updatePackage.getAccessKey()), updatePackage.getChannel());
                if (file.isFile()) {
                    com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
                }
                if (!file.mkdirs() && !file.isDirectory()) {
                    GeckoLogger.d("gecko-debug-tag", "can not create channel dir：", file.getAbsolutePath());
                    throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                    break;
                }
                com.bykv.vk.openvk.preload.geckox.g.a a11 = com.bykv.vk.openvk.preload.geckox.g.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                if (a11 != null) {
                    arrayList.add(new Pair(updatePackage.getChannel(), a11));
                    arrayList2.add(updatePackage);
                } else {
                    com.bykv.vk.openvk.preload.geckox.e.a aVar = this.f20755g;
                    updatePackage.getChannel();
                }
            } catch (Exception e11) {
                GeckoLogger.e("gecko-debug-tag", "filterChannel:", e11);
                updatePackage.getChannel();
                com.bykv.vk.openvk.preload.geckox.e.a aVar2 = this.f20755g;
            }
        }
        list.clear();
        list.addAll(arrayList2);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final void a(Object... objArr) {
        super.a(objArr);
        this.f20752d = (com.bykv.vk.openvk.preload.geckox.b) objArr[0];
        this.f20753e = (Map) objArr[1];
        this.f20754f = (Map) objArr[2];
        this.f20755g = (com.bykv.vk.openvk.preload.geckox.e.a) objArr[3];
        this.f20756h = (String) objArr[4];
    }
}
