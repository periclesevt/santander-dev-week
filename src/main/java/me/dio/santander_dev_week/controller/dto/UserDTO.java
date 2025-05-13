package me.dio.santander_dev_week.controller.dto;

import me.dio.santander_dev_week.domain.model.User;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDTO(
        Long id,
        String name,
        AccountDTO account,
        CardDTO card,
        List<FeatureDTO> features,
        List<NewsDTO> news) {

    public UserDTO(User model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getAccount()).map(AccountDTO::new).orElse(null),
                ofNullable(model.getCard()).map(CardDTO::new).orElse(null),
                ofNullable(model.getFeatures()).orElse(emptyList()).stream().map(FeatureDTO::new).collect(toList()),
                ofNullable(model.getNews()).orElse(emptyList()).stream().map(NewsDTO::new).collect(toList())
        );
    }

    public User toModel() {
        User model = new User();
        model.setId(this.id);
        model.setName(this.name);
        model.setAccount(ofNullable(this.account).map(AccountDTO::toModel).orElse(null));
        model.setCard(ofNullable(this.card).map(CardDTO::toModel).orElse(null));
        model.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDTO::toModel).collect(toList()));
        model.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDTO::toModel).collect(toList()));
        return model;
    }

}
