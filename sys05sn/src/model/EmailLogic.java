package model;

import org.apache.commons.lang3.StringUtils;

public class EmailLogic {

	public String createTestText(String kokugo, String sugaku, String eigo, String shakai, String rika){

		// テスト連絡のテキスト生成
		String testText = "";

		if(StringUtils.isNotBlank(kokugo)) {
			testText += ("国" + kokugo + ", ");
		}
		if(StringUtils.isNotBlank(sugaku)) {
			testText += ("数" + sugaku + ", ");
		}
		if(StringUtils.isNotBlank(eigo)) {
			testText += ("英" + eigo + ", ");
		}
		if(StringUtils.isNotBlank(shakai)) {
			testText += ("社" + shakai + ", ");
		}
		if(StringUtils.isNotBlank(rika)) {
			testText += ("理" + rika + ", ");
		}

		System.out.println("testText:" + testText);

		if(StringUtils.isNotBlank(testText)) {
			testText = "テスト：" + testText;
		}else{
			testText = "";
		}
		return testText;
	}

	public String createEmailText(String emailText){
		// メール本文のテキスト生成
		if(StringUtils.isNotBlank(emailText)){
			emailText = "連絡：" + emailText;
		}

		System.out.println("emailText:" + emailText);

		return emailText;
	}

}
