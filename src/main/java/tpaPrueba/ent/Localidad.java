package tpaPrueba.ent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@Entity
@Table(name = "autor")
@NoArgsConstructor
@AllArgsConstructor
public class Localidad extends Base{

    private static final long serialVersionUID = 1L;

    @Column(name = "denominacion")
    private String denominacion;

}