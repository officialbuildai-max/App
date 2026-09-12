package com.mbridge.msdk.playercommon.exoplayer2.offline;

import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.util.AtomicFile;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class ActionFile {
    static final int VERSION = 0;
    private final File actionFile;
    private final AtomicFile atomicFile;

    public ActionFile(File file) {
        this.actionFile = file;
        this.atomicFile = new AtomicFile(file);
    }

    public DownloadAction[] load(DownloadAction.Deserializer... deserializerArr) throws IOException {
        if (!this.actionFile.exists()) {
            return new DownloadAction[0];
        }
        try {
            InputStream openRead = this.atomicFile.openRead();
            DataInputStream dataInputStream = new DataInputStream(openRead);
            int readInt = dataInputStream.readInt();
            if (readInt > 0) {
                throw new IOException("Unsupported action file version: " + readInt);
            }
            int readInt2 = dataInputStream.readInt();
            DownloadAction[] downloadActionArr = new DownloadAction[readInt2];
            for (int i11 = 0; i11 < readInt2; i11++) {
                downloadActionArr[i11] = DownloadAction.deserializeFromStream(deserializerArr, dataInputStream);
            }
            Util.closeQuietly(openRead);
            return downloadActionArr;
        } catch (Throwable th2) {
            Util.closeQuietly((Closeable) null);
            throw th2;
        }
    }

    public void store(DownloadAction... downloadActionArr) throws IOException {
        DataOutputStream dataOutputStream;
        int i11;
        DataOutputStream dataOutputStream2 = null;
        try {
            dataOutputStream = new DataOutputStream(this.atomicFile.startWrite());
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(downloadActionArr.length);
            for (DownloadAction downloadAction : downloadActionArr) {
                DownloadAction.serializeToStream(downloadAction, dataOutputStream);
            }
            this.atomicFile.endWrite(dataOutputStream);
            Util.closeQuietly((Closeable) null);
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream2 = dataOutputStream;
            Util.closeQuietly(dataOutputStream2);
            throw th;
        }
    }
}
