package com.cap.resellers.mentoring;

public enum Question {

    FIRST(1, "폐업하게 된 가장 큰 이유가 무엇이었나요? 그리고 만약 다시 창업을 할 수 있다면, 어떻게 해당 문제를 극복하실 건가요?"),
    SECOND(2, "추천해줄 만한 납품업체/유통업체/광고업체가 있나요? 있다면 어떤 점에서 추천을 하고, 물품을 구매하는 사장님께 추천해드릴 의사가 있나요?"),
    THIRD(3, "사업 운영 중 고객이나 다른 사업자로부터 받은 가장 가치있는, 긍정적인 결과를 가져온 피드백은 무엇이었나요?")
    ;


    Question(Integer number, String question) {
        this.number = number;
        this.question = question;
    }

    private Integer number;
    private String question;

    public Integer getNumber() {
        return number;
    }

    public String getQuestion() {
        return question;
    }
}
