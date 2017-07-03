/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine.impl;

import java.util.List;

import org.camunda.bpm.engine.history.CleanableHistoricDecisionInstanceReport;
import org.camunda.bpm.engine.history.CleanableHistoricDecisionInstanceReportResult;
import org.camunda.bpm.engine.impl.interceptor.Command;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.impl.interceptor.CommandExecutor;

public class CleanableHistoricDecisionInstanceReportImpl implements CleanableHistoricDecisionInstanceReport {

  protected CommandExecutor commandExecutor;

  public CleanableHistoricDecisionInstanceReportImpl(CommandExecutor commandExecutor) {
    this.commandExecutor = commandExecutor;
  }

  @Override
  public List<CleanableHistoricDecisionInstanceReportResult> list() {
    return commandExecutor.execute(new Command<List<CleanableHistoricDecisionInstanceReportResult>>() {
      @Override
      public List<CleanableHistoricDecisionInstanceReportResult> execute(CommandContext commandContext) {
        return commandContext.getHistoricDecisionInstanceManager().findFinishedDecisionInstancesReportResults();
      }
    });
  }

}
