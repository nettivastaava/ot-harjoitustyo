/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisegenerator.dao;

import exercisegenerator.domain.Question;


public interface QuestionDao {
    Question create(Question q) throws Exception;

    String findBySetName(String set);
}
