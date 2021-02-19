//package pers.yjw.platform.demo.client.utils;
//
//import com.github.junrar.Archive;
//import com.github.junrar.rarfile.FileHeader;
//import eu.medsea.mimeutil.MimeUtil;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
//import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
//import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
//import org.apache.commons.compress.utils.Lists;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.tools.zip.ZipEntry;
//import org.apache.tools.zip.ZipFile;
//import org.apache.tools.zip.ZipOutputStream;
//import pers.yjw.platform.demo.client.exception.FileDecompressionException;
//import ws.schild.jave.MultimediaInfo;
//import ws.schild.jave.MultimediaObject;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Collection;
//import java.util.Enumeration;
//import java.util.List;
//
//import static cn.tongdun.hunter.code.JordanErrorCodeEnum.FILE_CREATE_NEW_FILE_ERROR;
//import static cn.tongdun.hunter.code.JordanErrorCodeEnum.FILE_DELETE_FAILED;
//
///**
// * @projectName demo
// * @version: 1.0
// * @packageName pers.yjw.platform.demo.client.utils
// * @description:文件基础工具类
// * @author: YaoJianwei
// * @create: 2019-09-10 16:39
// */
//@Slf4j
//public class FileUtil {
//
//	/**
//	 * 根据压缩文件的地址，解压文件
//	 *
//	 * @param filePath       压缩文件的路径
//	 * @param originFileName 压缩文件的原始文件名
//	 * @return 解压后的文件列表
//	 * @throws Exception 解压文件异常
//	 */
//	public static List<FileModel> uncompressFile(String filePath, String originFileName) throws Exception {
//		List<FileModel> fileModels = null;
//		if (StringUtils.isBlank(filePath)) {
//			throw new Exception("压缩包文件路径为空！");
//		}
//		String fileName = getFileNameByPath(filePath);
//		if (StringUtils.isEmpty(fileName)) {
//			throw new Exception("获取文件名失败，请检查压缩包文件路径是否非法！filePath: " + filePath + "，originFileName: " + originFileName);
//		}
//
//		String fileExtType = getFileExtType(originFileName);
//		if (StringUtils.isEmpty(fileExtType)) {
//			throw new Exception("获取文件类型失败，请检查压缩包文件路径是否非法！filePath: " + filePath + "，originFileName: " + originFileName);
//		}
//
//		// 保存压缩包解压后的文件目录，以压缩包名字去掉后缀为目录
//		String destDir = filePath.substring(0, filePath.lastIndexOf(".")) + File.separator;
//		fileExtType = fileExtType.toLowerCase();
//
//		if ("zip".equalsIgnoreCase(fileExtType)) {
//			fileModels = unZipFile(filePath, destDir);
//		} else if ("rar".equalsIgnoreCase(fileExtType)) {
//			fileModels = unRarFile(filePath, destDir);
//		} else if ("tar.gz".equalsIgnoreCase(fileExtType)) {
//			fileModels = unCompressArchiveGz(filePath, destDir);
//		}
//
//		return fileModels;
//	}
//
//	/**
//	 * 解压zip文件到指定目录
//	 *
//	 * @param zFilePath zip压缩包文件路径
//	 * @param destDir   存放解压后文件的目录
//	 * @return 解压后的文件模型列表
//	 * @throws Exception 解压zip文件异常
//	 */
//	private static List<FileModel> unZipFile(String zFilePath, String destDir) throws Exception {
//		File zFile = new File(zFilePath);
//		Long fileSize = zFile.length();
//		if ((!zFile.exists()) && (fileSize <= 0)) {
//			log.error("zip 文件路径：" + zFile.getAbsolutePath() + " is not exists");
//			throw new FileNotFoundException("File: " + zFile.getName() + " not found");
//		}
//
//		// 设置文件编码
//		ZipFile zipFile = null;
//		List<FileModel> fileModels = Lists.newArrayList();
//		try {
//			// 如果保存解压后的文件目录不存在，创建目录
//			FileUtil.mkDir(new File(destDir));
//
//			zipFile = new ZipFile(zFile, "utf8");
//			for (Enumeration entries = zipFile.getEntries(); entries.hasMoreElements(); ) {
//				ZipEntry zipEntry = (ZipEntry) entries.nextElement();
//				String entryName = zipEntry.getName();
//
//				// 判断全路径是否是文件夹
//				if (!zipEntry.isDirectory()) {
//					String originName = entryName.substring(entryName.lastIndexOf(File.separator) + 1);
//					if (originName.startsWith(".")) {
//						continue;
//					}
//
//					//原文件扩展名
//					String extName = entryName.substring(entryName.lastIndexOf("."));
//					String newFileName = String.valueOf(System.nanoTime()) + extName;
//					String fullFilePath = destDir + newFileName;
//					String mimeType = extName;
//					long ls = 0;
//					try (InputStream is = zipFile.getInputStream(zipEntry);
//						 BufferedInputStream bis = new BufferedInputStream(is);
//						 OutputStream os = new FileOutputStream(fullFilePath);
//						 BufferedOutputStream bos = new BufferedOutputStream(os)) {
//						byte[] buf = new byte[1024];
//						int len;
//						while ((len = bis.read(buf)) != -1) {
//							bos.write(buf, 0, len);
//						}
//					}
//					File file = new File(fullFilePath);
//					mimeType = getMimeType(fullFilePath);
//					ls = getDuration(file);
//					fileModels.add(new FileModel(fullFilePath, file.length(), originName, mimeType, ls));
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			log.error("zip 文件路径：" + zFile.getAbsolutePath() + " uncompress exception");
//		} finally {
//			if (null != zipFile) {
//				zipFile.close();
//			}
//		}
//
//		// 删除zip文件
//		if (!zFile.delete()) {
//			throw new FileDecompressionException(FILE_DELETE_FAILED);
//		}
//
//		return fileModels;
//	}
//
//
//	/**
//	 * 解压rar文件到指定目录
//	 *
//	 * @param srcFilePath rar压缩包文件路径
//	 * @param destDir     存放解压后文件的目录
//	 * @return 解压后文件模型列表
//	 * @throws Exception 解压rar文件异常
//	 */
//	private static List<FileModel> unRarFile(String srcFilePath, String destDir) throws Exception {
//		Archive archive = null;
//		List<FileModel> fileModels = Lists.newArrayList();
//		File rarFile = new File(srcFilePath);
//		Long fileSize = rarFile.length();
//
//		try {
//			// 如果保存解压后的文件目录不存在，创建目录
//			FileUtil.mkDir(new File(destDir));
//
//			archive = new Archive(rarFile, null);
//			if (archive.isEncrypted()) {
//				log.error("rar 文件路径：" + srcFilePath + " is encrypted");
//				throw new Exception("File: " + srcFilePath + " is encrypted");
//			}
//
//			List<FileHeader> fileHeaders = archive.getFileHeaders();
//			if (fileHeaders == null || fileHeaders.size() <= 0) {
//				log.error("rar 文件路径：" + srcFilePath + " file Header error");
//				throw new Exception("File: " + srcFilePath + " file Header error");
//			}
//
//			for (FileHeader fh : fileHeaders) {
//				if (fh.isEncrypted()) {
//					throw new Exception("File: " + srcFilePath + " is encrypted");
//				}
//
//				String fileName = fh.getFileNameW().isEmpty() ? fh.getFileNameString() : fh.getFileNameW();
//				if (StringUtils.isNotEmpty(fileName)) {
//					if (fh.isDirectory()) {
//						continue;
//					}
//
//					// 原文件扩展名
//					String extName = fileName.substring(fileName.lastIndexOf("."));
//					String newFileName = String.valueOf(System.nanoTime()) + extName;
//					String fullFilePath = destDir + newFileName;
//					String mineType = extName;
//					long ls = 0;
//					File outFile = new File(fullFilePath);
//					if (!outFile.exists()) {
//						if (!outFile.createNewFile()) {
//							throw new FileDecompressionException(FILE_CREATE_NEW_FILE_ERROR);
//						}
//					}
//
//					mineType = getMimeType(fullFilePath);
//
//					try (FileOutputStream fos = new FileOutputStream(outFile)) {
//						archive.extractFile(fh, fos);
//						fos.flush();
//						String originFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
//						ls = getDuration(outFile);
//						fileModels.add(new FileModel(fullFilePath, outFile.length(), originFileName, mineType, ls));
//					}
//				}
//			}
//		} catch (Exception ex) {
//			log.error("rar 文件路径：" + srcFilePath + "uncompress exception");
//			ex.printStackTrace();
//		} finally {
//			if (null != archive) {
//				archive.close();
//			}
//		}
//
//		// 删除rar文件
//		if (!rarFile.delete()) {
//			throw new FileDecompressionException(FILE_DELETE_FAILED);
//		}
//
//		return fileModels;
//	}
//
//	/**
//	 * @param archivePath tar.gz压缩包文件的路径
//	 * @param destDir     存放解压后文件的目录
//	 * @return 解压后的文件模型列表
//	 * @throws Exception 解压gz文件异常
//	 */
//	private static List<FileModel> unCompressArchiveGz(String archivePath, String destDir) throws Exception {
//		File file = new File(archivePath);
//		String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
//		String newFilePath = file.getParent() + File.separator + fileName;
//
//		try (FileInputStream is = new FileInputStream(file);
//			 FileOutputStream os = new FileOutputStream(newFilePath);
//			 BufferedInputStream bis = new BufferedInputStream(is);
//			 BufferedOutputStream bos = new BufferedOutputStream(os);
//			 GzipCompressorInputStream gcis = new GzipCompressorInputStream(bis)) {
//			// 如果保存解压后的文件目录不存在，创建目录
//			FileUtil.mkDir(new File(destDir));
//
//			byte[] buf = new byte[1024];
//			int len;
//			while ((len = gcis.read(buf)) != -1) {
//				bos.write(buf, 0, len);
//			}
//		}
//
//		// 删除gz文件
//		if (!file.delete()) {
//			throw new FileDecompressionException(FILE_DELETE_FAILED);
//		}
//
//		//解压.tar文件
//		return unCompressTar(newFilePath, destDir);
//	}
//
//
//	/**
//	 * 解压 .tar 文件
//	 *
//	 * @param tarFilePath tar压缩包文件的路径
//	 * @param destDir     存放解压后文件的目录
//	 * @return 解压后的文件模型列表
//	 * @throws Exception 解压tar文件异常
//	 */
//	private static List<FileModel> unCompressTar(String tarFilePath, String destDir) throws Exception {
//		File file = new File(tarFilePath);
//		List<FileModel> fileModels = Lists.newArrayList();
//
//		try (FileInputStream is = new FileInputStream(file);
//			 TarArchiveInputStream tais = new TarArchiveInputStream(is)) {
//			TarArchiveEntry entry;
//			while ((entry = tais.getNextTarEntry()) != null) {
//				if (entry.isDirectory()) {
//					continue;
//				}
//
//				String name = entry.getName();
//				log.error("FileUtil unCompressTar originFileName:" + name);
//
//				String originFileName = name.substring(name.lastIndexOf(File.separator) + 1);
//				if (originFileName.startsWith(".")) {
//					continue;
//				}
//
//				String extName = name.substring(name.lastIndexOf("."));
//				String newFileName = String.valueOf(System.nanoTime()) + extName;
//				String fullFilePath = destDir + newFileName;
//				String mimeType = extName;
//				long ls = 0;
//				try (FileOutputStream os = new FileOutputStream(fullFilePath);
//					 BufferedOutputStream bos = new BufferedOutputStream(os)) {
//					byte[] buf = new byte[1024];
//					int len;
//					while ((len = tais.read(buf)) != -1) {
//						bos.write(buf, 0, len);
//					}
//
//					mimeType = getMimeType(fullFilePath);
//					ls = getDuration(entry.getFile());
//					fileModels.add(new FileModel(fullFilePath, entry.getFile().length(), originFileName, mimeType,
//							ls));
//				}
//			}
//		}
//
//		// 删除tar文件
//		if (!file.delete()) {
//			throw new FileDecompressionException(FILE_DELETE_FAILED);
//		}
//		return fileModels;
//	}
//
//	/**
//	 * 判断文件夹是否存在，不耐则创建文件夹
//	 *
//	 * @param file 文件对象
//	 */
//	public static void mkDir(File file) {
//		if (!file.exists()) {
//			if (!file.mkdirs()) {
//				throw new FileDecompressionException(FILE_CREATE_NEW_FILE_ERROR);
//			}
//		}
//	}
//
//	/**
//	 * 获取文件扩展名（zip/rar/tar.gz等）
//	 *
//	 * @param fileName 文件名
//	 * @return 文件扩展名
//	 */
//	public static String getFileExtType(String fileName) {
//		//需要优化
//		if (fileName.endsWith("tar.gz")) {
//			return "tar.gz";
//		}
//
//		int lastIndex = fileName.lastIndexOf(".");
//		if (lastIndex > 0) {
//			return fileName.substring(lastIndex + 1);
//		}
//
//		return null;
//	}
//
//	/**
//	 * 是否是压缩文件
//	 *
//	 * @param fileName 文件名
//	 * @return 是否为压缩文件，true：是，false：否
//	 */
//	public static boolean isCompressedFile(String fileName) {
//		boolean compressed = false;
//		if (fileName.endsWith("tar.gz")) {
//			compressed = true;
//		} else if (fileName.endsWith("zip")) {
//			compressed = true;
//		} else if (fileName.endsWith("rar")) {
//			compressed = true;
//		}
//
//		return compressed;
//	}
//
//	/**
//	 * 将多个文件压缩到指定输出流中
//	 *
//	 * @param files        需要压缩的文件列表
//	 * @param outputStream 压缩到指定的输出流
//	 * @author hongwei.lian
//	 */
//	public static void compressZip(List<File> files, OutputStream outputStream) {
//		//-- 包装成ZIP格式输出流
//		try (ZipOutputStream zipOutStream = new ZipOutputStream(new BufferedOutputStream(outputStream))) {
//			// -- 设置压缩方法
//			zipOutStream.setMethod(ZipOutputStream.DEFLATED);
//			//-- 将多文件循环写入压缩包
//			for (int i = 0; i < files.size(); i++) {
//				File file = files.get(i);
//				try (FileInputStream fileInputStream = new FileInputStream(file)) {
//					byte[] data = new byte[(int) file.length()];
//					fileInputStream.read(data);
//					//-- 添加ZipEntry，并ZipEntry中写入文件流，这里，加上i是防止要下载的文件有重名的导致下载失败
//					zipOutStream.putNextEntry(new ZipEntry(i + "_" + file.getName()));
//					zipOutStream.write(data);
//					fileInputStream.close();
//					zipOutStream.closeEntry();
//				}
//			}
//		} catch (IOException e) {
//			log.error("compressZip - error: {}", e.getMessage());
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 根据文件路径获取文件名
//	 *
//	 * @param path 文件路径
//	 * @return 文件名
//	 */
//	public static String getFileNameByPath(String path) {
//		String name = path;
//		String separator = File.separatorChar == '\\' ? "\\\\" : File.separator;
//		String[] filePathInfo = path.split(separator);
//		if (filePathInfo.length > 1) {
//			name = filePathInfo[filePathInfo.length - 1];
//		}
//		return name;
//	}
//
//	public static String getMimeType(String filePath) {
//		if (filePath == null) {
//			log.info("传入文件路径为空");
//			return null;
//		}
//
//		Path path = Paths.get(filePath);
//		String fileContentType = null;
//		try {
//			fileContentType = Files.probeContentType(path);
//		} catch (IOException e) {
//			log.error("获取文件内容类型 originalName:" + filePath, e);
//		}
//		if (StringUtils.isBlank(fileContentType)) {
//			MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
//			File f = new File(filePath);
//			Collection<?> mimeTypes = MimeUtil.getMimeTypes(f);
//			if (mimeTypes != null && mimeTypes.size() > 0) {
//				fileContentType = mimeTypes.toString();
//			}
//		}
//		log.info("文件：{} 的MimeType为：{}", filePath, fileContentType);
//		return fileContentType;
//	}
//
//	public static long getDuration(File file) {
//		MultimediaObject instance = new MultimediaObject(file);
//		long duration = 0L;   //单位：毫秒
//		try {
//			MultimediaInfo multimediaInfo = instance.getInfo();
//			duration = multimediaInfo.getDuration();
//		} catch (Exception e) {
//			log.error("获取音频文件时长异常", e);
//		}
//
//		return duration;
//	}
//
//	/**
//	 * 文件模型类
//	 */
//	@Setter
//	@Getter
//	public static class FileModel {
//		/**
//		 * 文件所在路径
//		 */
//		private String filePath;
//
//		/**
//		 * 文件大小
//		 */
//		private Long fileSize = 0L;
//		/**
//		 * 语音文件时长
//		 */
//		private Long duration = 0L;
//
//		/**
//		 * 原始文件名
//		 */
//		private String originFileName = "";
//
//		/**
//		 * 文件系统中该文件ID
//		 */
//		private String fileId;
//
//		/**
//		 * 文件的mineType
//		 */
//		private String fileType;
//
//		private FileModel(String filePath, Long fileSize, String originFileName) {
//			this.filePath = filePath;
//			this.fileSize = fileSize;
//			this.originFileName = originFileName;
//		}
//
//		private FileModel(String filePath, Long fileSize, String originFileName, String fileType) {
//			this(filePath, fileSize, originFileName);
//			this.fileType = fileType;
//		}
//
//		private FileModel(String filePath, Long fileSize, String originFileName, String fileType, Long duration) {
//			this(filePath, fileSize, originFileName, fileType);
//			this.duration = duration;
//		}
//	}
//}
