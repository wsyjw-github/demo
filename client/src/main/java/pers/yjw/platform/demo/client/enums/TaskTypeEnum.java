package pers.yjw.platform.demo.client.enums;

import lombok.Getter;

/**
 * TaskTypeEnum
 *
 * @author yjw
 * @date 2020-02-11
 * @time 15:27
 * @desc
 */
@Getter
public enum TaskTypeEnum {
	TASKTYPE_AUDIO_IDENTIFICATION(0, "语音识别"),
	TASKTYPE_AUDIO_SYNTHESIS(1, "语音合成"),
	TASKTYPE_TEXT_LABEL(2, "文本标注"),
	TASKTYPE_IMAGE_OCR(3, "图像OCR"),
	TASKTYPE_IMAGE_CATEGORY(4, "图像分类"),
	TASKTYPE_VOICE_LIBRARY_LABEL(5, "音库标注"),
	TASKTYPE_VOICE_PRINT_LABEL(6, "声纹标注"),
	TASKTYPE_MOOD_LABEL(7,"情绪标注");
	
	private Integer value;
	private String name;
	
	TaskTypeEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
}
