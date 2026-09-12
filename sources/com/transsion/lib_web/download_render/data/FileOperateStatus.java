package com.transsion.lib_web.download_render.data;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/lib_web/download_render/data/FileOperateStatus;", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DELETE", "COPY", "DOWNLOAD", "NONE", "lib_web_release"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class FileOperateStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FileOperateStatus[] $VALUES;
    private final String type;
    public static final FileOperateStatus DELETE = new FileOperateStatus("DELETE", 0, "删除");
    public static final FileOperateStatus COPY = new FileOperateStatus("COPY", 1, "复制");
    public static final FileOperateStatus DOWNLOAD = new FileOperateStatus("DOWNLOAD", 2, "下载");
    public static final FileOperateStatus NONE = new FileOperateStatus("NONE", 3, "无状态");

    private static final /* synthetic */ FileOperateStatus[] $values() {
        return new FileOperateStatus[]{DELETE, COPY, DOWNLOAD, NONE};
    }

    static {
        FileOperateStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private FileOperateStatus(String str, int i11, String str2) {
        this.type = str2;
    }

    public static EnumEntries<FileOperateStatus> getEntries() {
        return $ENTRIES;
    }

    public static FileOperateStatus valueOf(String str) {
        return (FileOperateStatus) Enum.valueOf(FileOperateStatus.class, str);
    }

    public static FileOperateStatus[] values() {
        return (FileOperateStatus[]) $VALUES.clone();
    }

    public final String getType() {
        return this.type;
    }
}
