package sopt.sopt36goodoc.qna.dto.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import sopt.sopt36goodoc.qna.domain.QnA;

import java.util.stream.Collectors;

public record QnAPreviewResponses(
        Page<QnAPreviewResponse> qnAPreviews) {
    public static QnAPreviewResponses from(Page<QnA> qnAs){
        return new QnAPreviewResponses(
                new PageImpl<>(
                        qnAs.stream()
                                .map(QnAPreviewResponse::from)
                                .collect(Collectors.toList()),
                        qnAs.getPageable(),
                        qnAs.getTotalElements()
                )
        );
    }
}
