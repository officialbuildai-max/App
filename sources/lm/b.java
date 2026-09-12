package lm;

import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.task.compare.CompareRequest;
import com.transsion.lib_web.download_render.task.compare.CompareResponse;
import gm.i;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import km.b;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements km.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f69100a = "DR_VersionSameCompareStep";

    @Override // km.b
    public CompareResponse a(CompareRequest request, b.a chain) {
        Intrinsics.h(request, "request");
        Intrinsics.h(chain, "chain");
        PageData localPageData = request.getLocalPageData();
        PageData remotePageData = request.getRemotePageData();
        if (!Intrinsics.c(localPageData.getVersionCode(), remotePageData.getVersionCode())) {
            return chain.a(request);
        }
        i iVar = i.f64006a;
        iVar.a(b(), "<VersionSameCompareStep> load start");
        if (Intrinsics.c(localPageData.getDownloadStatus(), Boolean.TRUE)) {
            iVar.a(b(), "<VersionSameCompareStep> load end (no change)");
            return new CompareResponse(CollectionsKt.l(), CollectionsKt.l(), CollectionsKt.l(), 0L);
        }
        Map<String, FileData> localFileMap = localPageData.getLocalFileMap();
        List<FileData> files = remotePageData.getFiles();
        if (files == null) {
            files = CollectionsKt.l();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        long j11 = 0;
        for (FileData fileData : files) {
            Long size = fileData.getSize();
            j11 += size != null ? size.longValue() : 0L;
            FileData fileData2 = localFileMap.get(fileData.getFileUrl());
            if (fileData2 == null) {
                FileData c11 = c(fileData);
                String fileUrl = fileData.getFileUrl();
                if (fileUrl != null) {
                    if (c11 == null) {
                        fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.DOWNLOAD);
                        linkedHashMap3.put(fileUrl, fileData);
                    } else {
                        linkedHashMap2.put(fileUrl, c11);
                    }
                }
            } else if (Intrinsics.c(fileData2.getMd5(), fileData.getMd5())) {
                String fileUrl2 = fileData2.getFileUrl();
                if (fileUrl2 != null) {
                    linkedHashMap4.put(fileUrl2, fileData2);
                }
            } else {
                String fileUrl3 = fileData2.getFileUrl();
                if (fileUrl3 != null) {
                    fileData2.setFileOperateStatus$lib_web_release(FileOperateStatus.DELETE);
                    linkedHashMap.put(fileUrl3, fileData2);
                }
                FileData c12 = c(fileData);
                String fileUrl4 = fileData.getFileUrl();
                if (fileUrl4 != null) {
                    if (c12 == null) {
                        fileData.setFileOperateStatus$lib_web_release(FileOperateStatus.DOWNLOAD);
                        linkedHashMap3.put(fileUrl4, fileData);
                    } else {
                        linkedHashMap2.put(fileUrl4, c12);
                    }
                }
            }
        }
        for (Map.Entry<String, FileData> entry : localFileMap.entrySet()) {
            if (!linkedHashMap4.containsKey(entry.getKey())) {
                String key = entry.getKey();
                FileData value = entry.getValue();
                value.setFileOperateStatus$lib_web_release(FileOperateStatus.DELETE);
                linkedHashMap.put(key, value);
            }
        }
        i.f64006a.a(b(), "<VersionSameCompareStep> load end");
        return new CompareResponse(CollectionsKt.R0(linkedHashMap.values()), CollectionsKt.R0(linkedHashMap2.values()), CollectionsKt.R0(linkedHashMap3.values()), j11);
    }

    public String b() {
        return this.f69100a;
    }

    public FileData c(FileData fileData) {
        return b.C0839b.a(this, fileData);
    }
}
